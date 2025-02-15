package com.beuben.pokemontcgcollectorbackend.collection.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@With
@NoArgsConstructor
@AllArgsConstructor
public class Sealed {
  private Long id;
  private Long collectorId;
  private String label;
  private boolean isProtected;
  private BigDecimal protectionCost;
  private Condition condition;
  private Estimation estimation;
  private String picturesUrl;
  private String comment;
  private LocalDateTime creationDate;
}
