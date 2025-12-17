package com.triet.global_track_trace.domain.partner.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "business_partner")
public class BusinessPartner {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "partner_code", unique = true, nullable = false)
    private String partnerCode;

    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "partner_type")
    private PartnerType partnerType;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
}
