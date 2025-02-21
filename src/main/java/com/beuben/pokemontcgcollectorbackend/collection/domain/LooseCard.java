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
public class LooseCard {
  private Long id;
  private Long collectorId;
  private String label;
  private Long cardId;
  private Language language;
  private boolean firstEdition;
  private boolean reverseHolo;
  private Condition condition;
  private Estimation estimation;
  private String picturesUrl;
  private String comment;
  private LocalDateTime creationDate;
  private boolean isFromMasterSet;
  private Long masterSetId;
}
