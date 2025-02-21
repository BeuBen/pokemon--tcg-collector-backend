package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.dto.result;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record CollectionEstimationDetailDTO(
    Integer quantity,
    BigDecimal estimationInEuros) {
}
