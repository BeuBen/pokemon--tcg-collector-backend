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
public class Item {
  private Long id;
  private Long collectorId;
  private String label;
  private ItemType itemType;
  private Condition condition;
  private BigDecimal estimationEuros;
  private LocalDateTime estimationDate;
  private String estimationSourceUrl;
  private String picturesUrl;
  private String comment;
  private LocalDateTime creationDate;
}
