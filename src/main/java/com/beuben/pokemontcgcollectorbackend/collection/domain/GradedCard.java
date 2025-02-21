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
public class GradedCard {
  private Long id;
  private Long collectorId;
  private String label;
  private Long cardId;
  private Language language;
  private boolean isFirstEdition;
  private boolean isReverseHolo;
  private Grading grading;
  private Estimation estimation;
  private String picturesUrl;
  private String comment;
  private LocalDateTime creationDate;
  private boolean isFromMasterSet;
  private Long masterSetId;
}
