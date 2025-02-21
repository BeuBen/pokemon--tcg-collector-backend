package com.beuben.pokemontcgcollectorbackend.collection.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

import java.math.BigDecimal;
import java.util.Map;

@Data
@With
@NoArgsConstructor
@AllArgsConstructor
public class CollectionEstimation {
  private BigDecimal estimationInEuros;
  private Map<ItemType, CollectionEstimationDetail> detail;
}
