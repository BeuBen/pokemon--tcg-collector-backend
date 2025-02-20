package com.beuben.pokemontcgcollectorbackend.collection.application.port.out;

import com.beuben.pokemontcgcollectorbackend.collection.domain.Sealed;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SealedProvider {
  Flux<Sealed> findAllByCollectorId(Long collectorId);

  Mono<Sealed> findById(Long id);

  Mono<Sealed> add(Sealed sealed);

  Mono<Sealed> update(Sealed sealed);
}
