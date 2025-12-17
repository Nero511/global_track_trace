package com.triet.global_track_trace.web.response;

import com.triet.global_track_trace.domain.partner.entity.PartnerType;
import lombok.Data;

import java.util.UUID;

@Data
public class BusinessPartnerResponse {
    private UUID id;
    private String partnerCode;
    private String name;
    private PartnerType partnerType;
}
