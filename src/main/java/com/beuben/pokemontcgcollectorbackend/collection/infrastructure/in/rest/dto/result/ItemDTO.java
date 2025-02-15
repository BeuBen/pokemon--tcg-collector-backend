package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.dto.result;

import com.beuben.pokemontcgcollectorbackend.collection.domain.ItemType;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
public record ItemDTO(
    Long id,
    String label,
    ItemType itemType,
    BigDecimal estimationEuros,
    LocalDateTime estimationDate,
    String estimationSourceUrl,
    String picturesUrl,
    LocalDateTime creationDate) {
}
