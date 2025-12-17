package com.triet.global_track_trace.web.response;

import com.triet.global_track_trace.domain.tracking.entity.TrackingEventType;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class TrackingEventResponse {
    private UUID id;
    private UUID shipmentId;
    private TrackingEventType eventType;
    private UUID locationId;
    private LocalDateTime eventTime;
    private LocalDateTime createdAt;
}
