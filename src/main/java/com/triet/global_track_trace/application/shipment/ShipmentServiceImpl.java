package com.triet.global_track_trace.application.shipment;

import com.triet.global_track_trace.common.mapper.ShipmentMapper;
import com.triet.global_track_trace.common.mapper.TrackingEventMapper;
import com.triet.global_track_trace.domain.location.repository.LocationRepository;
import com.triet.global_track_trace.domain.partner.repository.BusinessPartnerRepository;
import com.triet.global_track_trace.domain.shipment.entity.Shipment;
import com.triet.global_track_trace.domain.shipment.entity.ShipmentStatus;
import com.triet.global_track_trace.domain.shipment.entity.ShipmentStatusHistory;
import com.triet.global_track_trace.domain.shipment.repository.ShipmentRepository;
import com.triet.global_track_trace.domain.shipment.repository.ShipmentStatusHistoryRepository;
import com.triet.global_track_trace.domain.tracking.repository.TrackingEventRepository;
import com.triet.global_track_trace.web.request.CreateShipmentRequest;
import com.triet.global_track_trace.web.response.ShipmentResponse;
import com.triet.global_track_trace.web.response.TrackingEventResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ShipmentServiceImpl implements ShipmentService {

    private final ShipmentRepository shipmentRepository;
    private final LocationRepository locationRepository;
    private final BusinessPartnerRepository businessPartnerRepository;
    private final ShipmentStatusHistoryRepository shipmentStatusHistoryRepository;
    private final TrackingEventRepository trackingEventRepository;
    private final ShipmentMapper shipmentMapper;
    private final TrackingEventMapper trackingEventMapper;

    @Override
    @Transactional
    public ShipmentResponse createShipment(CreateShipmentRequest request) {
        Shipment shipment = shipmentMapper.toEntity(request);

        // Resolve references
        if (request.getOriginLocationId() != null) {
            shipment.setOriginLocation(locationRepository.findById(request.getOriginLocationId())
                    .orElseThrow(() -> new RuntimeException("Origin Location not found")));
        }
        if (request.getDestinationLocationId() != null) {
            shipment.setDestinationLocation(locationRepository.findById(request.getDestinationLocationId())
                    .orElseThrow(() -> new RuntimeException("Destination Location not found")));
        }
        if (request.getShipperId() != null) {
            shipment.setShipper(businessPartnerRepository.findById(request.getShipperId())
                    .orElseThrow(() -> new RuntimeException("Shipper not found")));
        }
        if (request.getConsigneeId() != null) {
            shipment.setConsignee(businessPartnerRepository.findById(request.getConsigneeId())
                    .orElseThrow(() -> new RuntimeException("Consignee not found")));
        }

        // Set initial status if not provided
        if (shipment.getStatus() == null) {
            shipment.setStatus(ShipmentStatus.CREATED);
        }

        Shipment savedShipment = shipmentRepository.save(shipment);

        // Record history
        recordStatusChange(savedShipment, null, savedShipment.getStatus());

        return shipmentMapper.toResponse(savedShipment);
    }

    @Override
    public ShipmentResponse getShipmentByCode(String code) {
        Shipment shipment = shipmentRepository.findByCode(code)
                .orElseThrow(() -> new RuntimeException("Shipment not found with code: " + code));
        return shipmentMapper.toResponse(shipment);
    }

    @Override
    public List<TrackingEventResponse> getShipmentTimeline(String code) {
        Shipment shipment = shipmentRepository.findByCode(code)
                .orElseThrow(() -> new RuntimeException("Shipment not found with code: " + code));

        return trackingEventRepository.findByShipmentIdOrderByEventTimeDesc(shipment.getId())
                .stream()
                .map(trackingEventMapper::toResponse)
                .collect(Collectors.toList());
    }

    private void recordStatusChange(Shipment shipment, ShipmentStatus oldStatus, ShipmentStatus newStatus) {
        ShipmentStatusHistory history = new ShipmentStatusHistory();
        history.setShipment(shipment);
        history.setOldStatus(oldStatus);
        history.setNewStatus(newStatus);
        history.setChangedAt(LocalDateTime.now());
        shipmentStatusHistoryRepository.save(history);
    }
}
