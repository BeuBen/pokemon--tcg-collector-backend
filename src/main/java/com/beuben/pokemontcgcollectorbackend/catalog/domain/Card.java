package com.beuben.pokemontcgcollectorbackend.catalog.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

import java.util.List;
import java.util.Map;

@Data
@With
@AllArgsConstructor
@NoArgsConstructor
public class Card {
  private Long id;
  private String code;
  private String name;
  private CardSet set;
  private String rarity;
  private String number;
  private String image;

  public boolean isInList(final List<Card> cards) {
    return cards.stream()
        .anyMatch(card -> card.isSameAs(this));
  }

  private boolean isSameAs(final Card card) {
    return card.getCode().equals(this.code)
        && card.getName().equals(this.name);
  }

  public Card withCompletedSetFromSetMap(final Map<String, CardSet> cardSetsMap) {
    var setId = cardSetsMap.get(set.getCode()).getId();

    var setWithId = set.withId(setId);

    return this.withSet(setWithId);
  }
}
