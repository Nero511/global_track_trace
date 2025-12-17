package com.triet.global_track_trace.web.controller;

import com.triet.global_track_trace.application.partner.PartnerService;
import com.triet.global_track_trace.web.response.BusinessPartnerResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/partners")
@RequiredArgsConstructor
@Tag(name = "Partner Management", description = "APIs for managing business partners")
public class PartnerController {

    private final PartnerService partnerService;

    @GetMapping
    @Operation(summary = "Get all business partners")
    public ResponseEntity<List<BusinessPartnerResponse>> getAllPartners() {
        return ResponseEntity.ok(partnerService.getAllPartners());
    }
}
