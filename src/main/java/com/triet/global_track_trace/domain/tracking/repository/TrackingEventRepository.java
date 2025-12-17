package com.triet.global_track_trace.domain.tracking.repository;

import com.triet.global_track_trace.domain.tracking.entity.TrackingEvent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TrackingEventRepository extends JpaRepository<TrackingEvent, UUID> {
    List<TrackingEvent> findByShipmentIdOrderByEventTimeDesc(UUID shipmentId);
}
