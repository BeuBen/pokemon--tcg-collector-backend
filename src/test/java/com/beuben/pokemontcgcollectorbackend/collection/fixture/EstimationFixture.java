package com.beuben.pokemontcgcollectorbackend.collection.fixture;

import com.beuben.pokemontcgcollectorbackend.collection.domain.Estimation;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.dto.command.UpdateItemEstimationCommand;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class EstimationFixture {
  public static Estimation aValidEstimation() {
    return new Estimation()
        .withPriceInEuros(BigDecimal.TEN)
        .withDate(LocalDateTime.MIN)
        .withSourceUrl("estimation_url.com");
  }

  public static UpdateItemEstimationCommand aValidUpdateItemEstimationCommand() {
    return UpdateItemEstimationCommand.builder()
        .estimationEuros(BigDecimal.TEN)
        .estimationSourceUrl("estimation_url.com")
        .build();
  }
}
