package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.dto.command;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record UpdateItemEstimationCommand(
    @NotNull @Positive BigDecimal estimationEuros,
    @NotBlank String estimationSourceUrl) {
}
