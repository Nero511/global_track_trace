package com.triet.global_track_trace.domain.shipment.repository;

import com.triet.global_track_trace.domain.shipment.entity.ShipmentStatusHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ShipmentStatusHistoryRepository extends JpaRepository<ShipmentStatusHistory, UUID> {
}
