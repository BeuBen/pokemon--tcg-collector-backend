package com.beuben.pokemontcgcollectorbackend.collection.application.port.out;

import com.beuben.pokemontcgcollectorbackend.collection.domain.LooseCard;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface LooseCardProvider {
  Flux<LooseCard> findAllByCollectorId(Long collectorId);

  Mono<LooseCard> findById(Long id);

  Mono<LooseCard> add(LooseCard looseCard);

  Mono<LooseCard> update(LooseCard looseCard);
}
