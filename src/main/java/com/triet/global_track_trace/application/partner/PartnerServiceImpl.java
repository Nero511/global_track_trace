package com.triet.global_track_trace.application.partner;

import com.triet.global_track_trace.common.mapper.BusinessPartnerMapper;
import com.triet.global_track_trace.domain.partner.repository.BusinessPartnerRepository;
import com.triet.global_track_trace.web.response.BusinessPartnerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PartnerServiceImpl implements PartnerService {

    private final BusinessPartnerRepository businessPartnerRepository;
    private final BusinessPartnerMapper businessPartnerMapper;

    @Override
    public List<BusinessPartnerResponse> getAllPartners() {
        return businessPartnerRepository.findAll().stream()
                .map(businessPartnerMapper::toResponse)
                .collect(Collectors.toList());
    }
}
