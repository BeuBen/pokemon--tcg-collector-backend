package com.beuben.pokemontcgcollectorbackend.collection.application.port.out;

import com.beuben.pokemontcgcollectorbackend.collection.domain.GradedCard;
import reactor.core.publisher.Flux;

public interface GradedCardProvider {
  Flux<GradedCard> findAllByCollectorId(Long collectorId);
}
