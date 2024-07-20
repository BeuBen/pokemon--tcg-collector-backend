package com.beuben.pokemontcgcollectorbackend.synchronization.domain.card;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class Card {
  private Long id;
  private String code;
  private String name;

  public boolean isInSet(final Set<Card> cardSet) {
    return cardSet.stream()
        .anyMatch(card -> card.isSameAs(this));
  }

  private boolean isSameAs(final Card card) {
    return card.getCode().equals(this.code)
        && card.getName().equals(this.name);
  }
}
