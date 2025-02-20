package com.beuben.pokemontcgcollectorbackend.collection.application.port.in.fetch;

import com.beuben.pokemontcgcollectorbackend.collection.domain.GradedCard;
import reactor.core.publisher.Flux;

public interface FetchAllCollectorGradedCards {
  Flux<GradedCard> execute(Long collectorId);
}
