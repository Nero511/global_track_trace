package com.triet.global_track_trace.application.partner;

import com.triet.global_track_trace.web.response.BusinessPartnerResponse;
import java.util.List;

public interface PartnerService {
    List<BusinessPartnerResponse> getAllPartners();
}
