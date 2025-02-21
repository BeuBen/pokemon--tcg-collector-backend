package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.dto.result;

import com.beuben.pokemontcgcollectorbackend.collection.domain.ItemType;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.Map;

@Builder
public record CollectionEstimationDTO(
    BigDecimal estimationInEuros,
    Map<ItemType, CollectionEstimationDetailDTO> detail) {
}
