package com.triet.global_track_trace.common.mapper;

import com.triet.global_track_trace.domain.shipment.entity.Shipment;
import com.triet.global_track_trace.web.request.CreateShipmentRequest;
import com.triet.global_track_trace.web.response.ShipmentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ShipmentMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "originLocation", ignore = true) // Handled in service
    @Mapping(target = "destinationLocation", ignore = true) // Handled in service
    @Mapping(target = "shipper", ignore = true) // Handled in service
    @Mapping(target = "consignee", ignore = true) // Handled in service
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Shipment toEntity(CreateShipmentRequest request);

    @Mapping(source = "originLocation.id", target = "originLocationId")
    @Mapping(source = "destinationLocation.id", target = "destinationLocationId")
    @Mapping(source = "shipper.id", target = "shipperId")
    @Mapping(source = "consignee.id", target = "consigneeId")
    ShipmentResponse toResponse(Shipment shipment);
}
