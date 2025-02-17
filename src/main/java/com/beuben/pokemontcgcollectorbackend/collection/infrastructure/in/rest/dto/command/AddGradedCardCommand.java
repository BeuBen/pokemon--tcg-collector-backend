package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.dto.command;

import com.beuben.pokemontcgcollectorbackend.collection.domain.Language;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record AddGradedCardCommand(
    @NotEmpty String label,
    @NotNull Long cardId,
    @NotNull Language language,
    boolean firstEdition,
    boolean reverseHolo,
    @NotEmpty String gradingSociety,
    @NotEmpty String grade,
    @NotEmpty String gradingReference,
    @NotNull BigDecimal estimationEuros,
    @NotEmpty String estimationSourceUrl,
    @NotEmpty String picturesUrl,
    String comment) {
}
