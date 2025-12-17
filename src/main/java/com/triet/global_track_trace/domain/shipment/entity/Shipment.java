package com.triet.global_track_trace.domain.shipment.entity;

import com.triet.global_track_trace.domain.location.entity.Location;
import com.triet.global_track_trace.domain.partner.entity.BusinessPartner;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "shipment")
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true, nullable = false)
    private String code;

    @Enumerated(EnumType.STRING)
    private ShipmentStatus status;

    @ManyToOne
    @JoinColumn(name = "origin_location_id")
    private Location originLocation;

    @ManyToOne
    @JoinColumn(name = "destination_location_id")
    private Location destinationLocation;

    @ManyToOne
    @JoinColumn(name = "shipper_id")
    private BusinessPartner shipper;

    @ManyToOne
    @JoinColumn(name = "consignee_id")
    private BusinessPartner consignee;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
