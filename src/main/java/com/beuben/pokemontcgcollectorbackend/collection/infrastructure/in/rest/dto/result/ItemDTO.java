package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.dto.result;

import com.beuben.pokemontcgcollectorbackend.collection.domain.Condition;
import com.beuben.pokemontcgcollectorbackend.collection.domain.ItemType;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
public record ItemDTO(
    Long id,
    Long collectorId,
    String label,
    ItemType itemType,
    Condition condition,
    BigDecimal estimationEuros,
    LocalDateTime estimationDate,
    String estimationSourceUrl,
    String picturesUrl,
    String comment,
    LocalDateTime creationDate) {
}
