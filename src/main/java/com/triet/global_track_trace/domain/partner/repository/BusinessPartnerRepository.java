package com.triet.global_track_trace.domain.partner.repository;

import com.triet.global_track_trace.domain.partner.entity.BusinessPartner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BusinessPartnerRepository extends JpaRepository<BusinessPartner, UUID> {
}
