package com.beuben.pokemontcgcollectorbackend.collection.application.port.out;

import com.beuben.pokemontcgcollectorbackend.collection.domain.GradedCard;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface GradedCardProvider {
  Flux<GradedCard> findAllByCollectorId(Long collectorId);

  Mono<GradedCard> findById(Long id);

  Mono<GradedCard> add(GradedCard gradedCard);

  Mono<GradedCard> update(GradedCard gradedCard);
}
