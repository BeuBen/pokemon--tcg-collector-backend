package com.beuben.pokemontcgcollectorbackend.collection.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.With;

import java.util.Map;
import java.util.Set;

@Data
@With
@AllArgsConstructor
public class Card {
  private Long id;
  private String code;
  private String name;
  private CardSet set;
  private String rarity;
  private String number;
  private String image;

  public boolean isInSet(final Set<Card> cardSet) {
    return cardSet.stream()
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
