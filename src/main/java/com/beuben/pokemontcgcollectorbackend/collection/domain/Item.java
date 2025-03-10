package com.beuben.pokemontcgcollectorbackend.collection.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

import java.time.LocalDateTime;

@Data
@With
@NoArgsConstructor
@AllArgsConstructor
public class Item {
  private Long id;
  private String label;
  private ItemType itemType;
  private Estimation estimation;
  private String picturesUrl;
  private LocalDateTime creationDate;
}
