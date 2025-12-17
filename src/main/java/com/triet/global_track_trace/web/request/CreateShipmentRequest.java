package com.triet.global_track_trace.web.request;

import com.triet.global_track_trace.domain.shipment.entity.ShipmentStatus;
import lombok.Data;

import java.util.UUID;

@Data
public class CreateShipmentRequest {
    private String code;
    private UUID originLocationId;
    private UUID destinationLocationId;
    private UUID shipperId;
    private UUID consigneeId;
    private ShipmentStatus status;
}
