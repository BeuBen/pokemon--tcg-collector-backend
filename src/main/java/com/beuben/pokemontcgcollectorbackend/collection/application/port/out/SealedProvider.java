package com.beuben.pokemontcgcollectorbackend.collection.application.port.out;

import com.beuben.pokemontcgcollectorbackend.collection.domain.Sealed;
import reactor.core.publisher.Flux;

public interface SealedProvider {
  Flux<Sealed> findAllByCollectorId(Long collectorId);
}
