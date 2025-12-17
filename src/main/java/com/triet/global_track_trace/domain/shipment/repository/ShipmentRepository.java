package com.triet.global_track_trace.domain.shipment.repository;

import com.triet.global_track_trace.domain.shipment.entity.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ShipmentRepository extends JpaRepository<Shipment, UUID> {
    Optional<Shipment> findByCode(String code);
}
