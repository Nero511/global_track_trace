package com.triet.global_track_trace.application.document;

import com.triet.global_track_trace.common.mapper.DocumentMapper;
import com.triet.global_track_trace.domain.document.entity.TransportDocument;
import com.triet.global_track_trace.domain.document.repository.TransportDocumentRepository;
import com.triet.global_track_trace.domain.shipment.entity.Shipment;
import com.triet.global_track_trace.domain.shipment.repository.ShipmentRepository;
import com.triet.global_track_trace.web.request.CreateDocumentRequest;
import com.triet.global_track_trace.web.response.DocumentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DocumentServiceImpl implements DocumentService {

    private final TransportDocumentRepository documentRepository;
    private final ShipmentRepository shipmentRepository;
    private final DocumentMapper documentMapper;

    @Override
    @Transactional
    public DocumentResponse addDocument(String shipmentCode, CreateDocumentRequest request) {
        Shipment shipment = shipmentRepository.findByCode(shipmentCode)
                .orElseThrow(() -> new RuntimeException("Shipment not found with code: " + shipmentCode));

        TransportDocument document = documentMapper.toEntity(request);
        document.setShipment(shipment);

        TransportDocument savedDocument = documentRepository.save(document);
        return documentMapper.toResponse(savedDocument);
    }
}
