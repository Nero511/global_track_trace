package com.triet.global_track_trace.domain.tracking.entity;

import com.triet.global_track_trace.domain.location.entity.Location;
import com.triet.global_track_trace.domain.shipment.entity.Shipment;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "tracking_event")
public class TrackingEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "shipment_id")
    private Shipment shipment;

    @Enumerated(EnumType.STRING)
    @Column(name = "event_type")
    private TrackingEventType eventType;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @Column(name = "event_time")
    private LocalDateTime eventTime;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
}
