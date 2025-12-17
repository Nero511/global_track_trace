package com.triet.global_track_trace.web.controller;

import com.triet.global_track_trace.application.shipment.ShipmentService;
import com.triet.global_track_trace.application.tracking.TrackingService;
import com.triet.global_track_trace.application.document.DocumentService;
import com.triet.global_track_trace.web.request.CreateDocumentRequest;
import com.triet.global_track_trace.web.request.CreateShipmentRequest;
import com.triet.global_track_trace.web.request.CreateTrackingEventRequest;
import com.triet.global_track_trace.web.response.DocumentResponse;
import com.triet.global_track_trace.web.response.ShipmentResponse;
import com.triet.global_track_trace.web.response.TrackingEventResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/shipments")
@RequiredArgsConstructor
@Tag(name = "Shipment Management", description = "APIs for managing shipments")
public class ShipmentController {

    private final ShipmentService shipmentService;
    private final TrackingService trackingService;
    private final DocumentService documentService;

    @PostMapping
    @Operation(summary = "Create a new shipment")
    public ResponseEntity<ShipmentResponse> createShipment(@Valid @RequestBody CreateShipmentRequest request) {
        return new ResponseEntity<>(shipmentService.createShipment(request), HttpStatus.CREATED);
    }

    @GetMapping("/{code}")
    @Operation(summary = "Get shipment details by code")
    public ResponseEntity<ShipmentResponse> getShipment(@PathVariable String code) {
        return ResponseEntity.ok(shipmentService.getShipmentByCode(code));
    }

    @GetMapping("/{code}/timeline")
    @Operation(summary = "Get tracking timeline for a shipment")
    public ResponseEntity<List<TrackingEventResponse>> getShipmentTimeline(@PathVariable String code) {
        return ResponseEntity.ok(shipmentService.getShipmentTimeline(code));
    }

    @PostMapping("/{code}/tracking-events")
    @Operation(summary = "Add a tracking event to a shipment")
    public ResponseEntity<TrackingEventResponse> addTrackingEvent(
            @PathVariable String code,
            @Valid @RequestBody CreateTrackingEventRequest request) {
        return new ResponseEntity<>(trackingService.addTrackingEvent(code, request), HttpStatus.CREATED);
    }

    @PostMapping("/{code}/documents")
    @Operation(summary = "Add a document to a shipment")
    public ResponseEntity<DocumentResponse> addDocument(
            @PathVariable String code,
            @Valid @RequestBody CreateDocumentRequest request) {
        return new ResponseEntity<>(documentService.addDocument(code, request), HttpStatus.CREATED);
    }
}
