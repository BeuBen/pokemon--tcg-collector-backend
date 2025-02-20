package com.beuben.pokemontcgcollectorbackend.catalog.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

import java.time.LocalDateTime;
import java.util.List;

@Data
@With
@AllArgsConstructor
@NoArgsConstructor
public class CardSet {
  private Long id;
  private String code;
  private String name;
  private String series;
  private Integer cardTotal;
  private LocalDateTime releaseDate;
  private String symbolImage;
  private String logoImage;

  public boolean isInList(final List<CardSet> cardSets) {
    return cardSets.stream()
        .anyMatch(cardSet -> cardSet.isSameAs(this));
  }

  private boolean isSameAs(final CardSet cardSet) {
    return cardSet.getCode().equals(this.code)
        && cardSet.getName().equals(this.name);
  }
}
