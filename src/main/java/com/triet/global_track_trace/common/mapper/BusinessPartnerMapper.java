package com.triet.global_track_trace.common.mapper;

import com.triet.global_track_trace.domain.partner.entity.BusinessPartner;
import com.triet.global_track_trace.web.response.BusinessPartnerResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BusinessPartnerMapper {
    BusinessPartnerResponse toResponse(BusinessPartner businessPartner);
}
