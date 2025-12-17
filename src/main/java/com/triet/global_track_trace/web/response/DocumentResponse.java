package com.triet.global_track_trace.web.response;

import com.triet.global_track_trace.domain.document.entity.DocumentType;
import lombok.Data;

import java.util.UUID;

@Data
public class DocumentResponse {
    private UUID id;
    private DocumentType documentType;
    private String fileName;
}
