package com.beuben.pokemontcgcollectorbackend.collection.application.port.out;

import com.beuben.pokemontcgcollectorbackend.collection.domain.Goodies;
import reactor.core.publisher.Flux;

public interface GoodiesProvider {
  Flux<Goodies> findAllByCollectorId(Long collectorId);
}
