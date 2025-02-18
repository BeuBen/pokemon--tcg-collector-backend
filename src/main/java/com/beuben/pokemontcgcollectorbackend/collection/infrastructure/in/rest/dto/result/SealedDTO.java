package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.dto.result;

import com.beuben.pokemontcgcollectorbackend.collection.domain.Condition;
import com.beuben.pokemontcgcollectorbackend.collection.domain.Estimation;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
public record SealedDTO(
    Long id,
    Long collectorId,
    String label,
    boolean hasProtection,
    BigDecimal protectionCost,
    Condition condition,
    Estimation estimation,
    String picturesUrl,
    String comment,
    LocalDateTime creationDate) {
}
