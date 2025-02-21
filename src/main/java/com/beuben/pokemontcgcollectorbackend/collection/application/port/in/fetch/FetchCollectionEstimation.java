package com.beuben.pokemontcgcollectorbackend.collection.application.port.in.fetch;

import com.beuben.pokemontcgcollectorbackend.collection.domain.CollectionEstimation;
import reactor.core.publisher.Mono;

public interface FetchCollectionEstimation {
  Mono<CollectionEstimation> execute(Long collectorId);
}
