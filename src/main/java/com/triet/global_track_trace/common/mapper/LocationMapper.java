package com.triet.global_track_trace.common.mapper;

import com.triet.global_track_trace.domain.location.entity.Location;
import com.triet.global_track_trace.web.response.LocationResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LocationMapper {
    LocationResponse toResponse(Location location);
}
