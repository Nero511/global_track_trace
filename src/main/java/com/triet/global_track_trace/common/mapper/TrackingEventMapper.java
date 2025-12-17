package com.triet.global_track_trace.common.mapper;

import com.triet.global_track_trace.domain.tracking.entity.TrackingEvent;
import com.triet.global_track_trace.web.request.CreateTrackingEventRequest;
import com.triet.global_track_trace.web.response.TrackingEventResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TrackingEventMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "shipment", ignore = true)
    @Mapping(target = "location", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    TrackingEvent toEntity(CreateTrackingEventRequest request);

    @Mapping(source = "shipment.id", target = "shipmentId")
    @Mapping(source = "location.id", target = "locationId")
    TrackingEventResponse toResponse(TrackingEvent trackingEvent);
}
