package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.dto.result;

import com.beuben.pokemontcgcollectorbackend.collection.domain.Condition;
import com.beuben.pokemontcgcollectorbackend.collection.domain.Estimation;
import com.beuben.pokemontcgcollectorbackend.collection.domain.GoodiesType;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record GoodiesDTO(
    Long id,
    Long collectorId,
    String label,
    GoodiesType goodiesType,
    Condition condition,
    Estimation estimation,
    String picturesUrl,
    String comment,
    LocalDateTime creationDate) {
}
