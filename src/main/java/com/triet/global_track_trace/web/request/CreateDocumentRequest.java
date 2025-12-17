package com.triet.global_track_trace.web.request;

import com.triet.global_track_trace.domain.document.entity.DocumentType;
import lombok.Data;

@Data
public class CreateDocumentRequest {
    private DocumentType documentType;
    private String fileName;
}
