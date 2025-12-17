package com.triet.global_track_trace.common.mapper;

import com.triet.global_track_trace.domain.document.entity.TransportDocument;
import com.triet.global_track_trace.web.request.CreateDocumentRequest;
import com.triet.global_track_trace.web.response.DocumentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DocumentMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "shipment", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    TransportDocument toEntity(CreateDocumentRequest request);

    DocumentResponse toResponse(TransportDocument document);
}
