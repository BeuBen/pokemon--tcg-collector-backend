package com.beuben.pokemontcgcollectorbackend.collection.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

import java.math.BigDecimal;

@Data
@With
@NoArgsConstructor
@AllArgsConstructor
public class CollectionEstimationDetail {
  private Integer quantity;
  private BigDecimal estimationInEuros;
}
