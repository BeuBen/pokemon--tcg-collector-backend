package com.beuben.pokemontcgcollectorbackend.collection.application.port.in;

import com.beuben.pokemontcgcollectorbackend.collection.domain.GradedCard;
import reactor.core.publisher.Mono;

public interface AddGradedCardToCollection {
  Mono<GradedCard> execute(GradedCard gradedCard);
}
