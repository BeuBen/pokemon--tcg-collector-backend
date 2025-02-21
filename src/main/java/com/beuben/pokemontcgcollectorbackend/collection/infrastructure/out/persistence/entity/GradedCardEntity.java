package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.entity;

import com.beuben.pokemontcgcollectorbackend.collection.domain.Language;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table("graded_card")
@Data
@With
@AllArgsConstructor
@NoArgsConstructor
public class GradedCardEntity {
  @Id
  private Long id;
  private Long collectorId;
  private String label;
  private Long cardId;
  private Language language;
  private boolean isFirstEdition;
  private boolean isReverseHolo;
  private String gradingSociety;
  private String grade;
  private String gradingReference;
  private BigDecimal estimationEuros;
  private LocalDateTime estimationDate;
  private String estimationSourceUrl;
  private String picturesUrl;
  private String comment;
  private LocalDateTime creationDate;
  private boolean isFromMasterSet;
  private Long masterSetId;
}
