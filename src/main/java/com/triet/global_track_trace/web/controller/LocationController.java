package com.triet.global_track_trace.web.controller;

import com.triet.global_track_trace.application.location.LocationService;
import com.triet.global_track_trace.web.response.LocationResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/locations")
@RequiredArgsConstructor
@Tag(name = "Location Management", description = "APIs for managing locations")
public class LocationController {

    private final LocationService locationService;

    @GetMapping
    @Operation(summary = "Get all locations")
    public ResponseEntity<List<LocationResponse>> getAllLocations() {
        return ResponseEntity.ok(locationService.getAllLocations());
    }
}
