package com.triet.global_track_trace.application.tracking;

import com.triet.global_track_trace.web.request.CreateTrackingEventRequest;
import com.triet.global_track_trace.web.response.TrackingEventResponse;

public interface TrackingService {
    TrackingEventResponse addTrackingEvent(String shipmentCode, CreateTrackingEventRequest request);
}
