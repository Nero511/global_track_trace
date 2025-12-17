package com.triet.global_track_trace.application.location;

import com.triet.global_track_trace.common.mapper.LocationMapper;
import com.triet.global_track_trace.domain.location.repository.LocationRepository;
import com.triet.global_track_trace.web.response.LocationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;
    private final LocationMapper locationMapper;

    @Override
    public List<LocationResponse> getAllLocations() {
        return locationRepository.findAll().stream()
                .map(locationMapper::toResponse)
                .collect(Collectors.toList());
    }
}
