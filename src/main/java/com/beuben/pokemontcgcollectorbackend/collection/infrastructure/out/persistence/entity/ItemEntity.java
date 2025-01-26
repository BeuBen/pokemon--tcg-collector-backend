package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.entity;

import com.beuben.pokemontcgcollectorbackend.collection.domain.Condition;
import com.beuben.pokemontcgcollectorbackend.collection.domain.ItemType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table("item")
@Data
@With
@AllArgsConstructor
@NoArgsConstructor
public class ItemEntity {
  @Id
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
