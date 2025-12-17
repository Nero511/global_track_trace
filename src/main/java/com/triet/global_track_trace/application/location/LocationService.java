package com.triet.global_track_trace.application.location;

import com.triet.global_track_trace.web.response.LocationResponse;
import java.util.List;

public interface LocationService {
    List<LocationResponse> getAllLocations();
}
