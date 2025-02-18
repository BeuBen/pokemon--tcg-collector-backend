package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.dto.command;

import com.beuben.pokemontcgcollectorbackend.collection.domain.Condition;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record AddMasterSetCommand(
    @NotEmpty String label,
    @NotNull Long setId,
    @NotNull BigDecimal completionRate,
    @NotNull Condition condition,
    @NotNull BigDecimal estimationEuros,
    @NotEmpty String estimationSourceUrl,
    @NotEmpty String picturesUrl,
    String comment) {
}
