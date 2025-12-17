package com.triet.global_track_trace.application.shipment;

import com.triet.global_track_trace.web.request.CreateShipmentRequest;
import com.triet.global_track_trace.web.response.ShipmentResponse;
import com.triet.global_track_trace.web.response.TrackingEventResponse;

import java.util.List;

public interface ShipmentService {
    ShipmentResponse createShipment(CreateShipmentRequest request);

    ShipmentResponse getShipmentByCode(String code);

    List<TrackingEventResponse> getShipmentTimeline(String code);
}
