package com.triet.global_track_trace.domain.location.repository;

import com.triet.global_track_trace.domain.location.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LocationRepository extends JpaRepository<Location, UUID> {
}
