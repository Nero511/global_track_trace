package com.triet.global_track_trace.web.response;

import lombok.Data;
import java.util.UUID;

@Data
public class LocationResponse {
    private UUID id;
    private String locationCode;
    private String name;
    private String country;
    private String city;
}
