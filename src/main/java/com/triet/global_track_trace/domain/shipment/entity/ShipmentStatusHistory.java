package com.triet.global_track_trace.domain.shipment.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "shipment_status_history")
public class ShipmentStatusHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "shipment_id")
    private Shipment shipment;

    @Enumerated(EnumType.STRING)
    @Column(name = "old_status")
    private ShipmentStatus oldStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "new_status")
    private ShipmentStatus newStatus;

    @Column(name = "changed_at")
    private LocalDateTime changedAt;
}
