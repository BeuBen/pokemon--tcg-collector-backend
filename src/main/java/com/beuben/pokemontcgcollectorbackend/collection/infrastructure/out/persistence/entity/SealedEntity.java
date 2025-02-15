package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.entity;

import com.beuben.pokemontcgcollectorbackend.collection.domain.Condition;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table("sealed")
@Data
@With
@AllArgsConstructor
@NoArgsConstructor
public class SealedEntity {
  @Id
  private Long id;
  private Long collectorId;
  private String label;
  private boolean isProtected;
  private BigDecimal protectionCost;
  private Condition condition;
  private BigDecimal estimationEuros;
  private LocalDateTime estimationDate;
  private String estimationSourceUrl;
  private String picturesUrl;
  private String comment;
  private LocalDateTime creationDate;
}
