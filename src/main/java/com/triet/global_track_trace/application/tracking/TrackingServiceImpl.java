package com.triet.global_track_trace.application.tracking;

import com.triet.global_track_trace.common.mapper.TrackingEventMapper;
import com.triet.global_track_trace.domain.location.repository.LocationRepository;
import com.triet.global_track_trace.domain.shipment.entity.Shipment;
import com.triet.global_track_trace.domain.shipment.repository.ShipmentRepository;
import com.triet.global_track_trace.domain.tracking.entity.TrackingEvent;
import com.triet.global_track_trace.domain.tracking.repository.TrackingEventRepository;
import com.triet.global_track_trace.web.request.CreateTrackingEventRequest;
import com.triet.global_track_trace.web.response.TrackingEventResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TrackingServiceImpl implements TrackingService {

    private final TrackingEventRepository trackingEventRepository;
    private final ShipmentRepository shipmentRepository;
    private final LocationRepository locationRepository;
    private final TrackingEventMapper trackingEventMapper;

    @Override
    @Transactional
    public TrackingEventResponse addTrackingEvent(String shipmentCode, CreateTrackingEventRequest request) {
        Shipment shipment = shipmentRepository.findByCode(shipmentCode)
                .orElseThrow(() -> new RuntimeException("Shipment not found with code: " + shipmentCode));

        TrackingEvent trackingEvent = trackingEventMapper.toEntity(request);
        trackingEvent.setShipment(shipment);

        if (request.getLocationId() != null) {
            trackingEvent.setLocation(locationRepository.findById(request.getLocationId())
                    .orElseThrow(() -> new RuntimeException("Location not found")));
        }

        TrackingEvent savedEvent = trackingEventRepository.save(trackingEvent);
        return trackingEventMapper.toResponse(savedEvent);
    }
}
