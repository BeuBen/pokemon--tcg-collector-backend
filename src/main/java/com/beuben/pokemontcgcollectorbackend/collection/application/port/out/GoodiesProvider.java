package com.beuben.pokemontcgcollectorbackend.collection.application.port.out;

import com.beuben.pokemontcgcollectorbackend.collection.domain.Goodies;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface GoodiesProvider {
  Flux<Goodies> findAllByCollectorId(Long collectorId);

  Mono<Goodies> findById(Long id);

  Mono<Goodies> add(Goodies goodies);
}
