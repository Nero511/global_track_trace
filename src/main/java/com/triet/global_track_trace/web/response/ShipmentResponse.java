package com.triet.global_track_trace.web.response;

import com.triet.global_track_trace.domain.shipment.entity.ShipmentStatus;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class ShipmentResponse {
    private UUID id;
    private String code;
    private ShipmentStatus status;
    private UUID originLocationId;
    private UUID destinationLocationId;
    private UUID shipperId;
    private UUID consigneeId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
