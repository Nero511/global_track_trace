package com.triet.global_track_trace.application.document;

import com.triet.global_track_trace.web.request.CreateDocumentRequest;
import com.triet.global_track_trace.web.response.DocumentResponse;

public interface DocumentService {
    DocumentResponse addDocument(String shipmentCode, CreateDocumentRequest request);
}
