package com.triet.global_track_trace.domain.document.repository;

import com.triet.global_track_trace.domain.document.entity.TransportDocument;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TransportDocumentRepository extends JpaRepository<TransportDocument, UUID> {
}
