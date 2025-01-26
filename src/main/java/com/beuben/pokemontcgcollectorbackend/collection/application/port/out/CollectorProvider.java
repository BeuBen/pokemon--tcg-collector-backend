package com.beuben.pokemontcgcollectorbackend.collection.application.port.out;

import com.beuben.pokemontcgcollectorbackend.collection.domain.Collector;
import reactor.core.publisher.Mono;

public interface CollectorProvider {
  Mono<Collector> findByUsername(final String username);
}
