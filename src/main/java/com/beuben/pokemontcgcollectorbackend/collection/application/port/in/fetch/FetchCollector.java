package com.beuben.pokemontcgcollectorbackend.collection.application.port.in.fetch;

import com.beuben.pokemontcgcollectorbackend.collection.domain.Collector;
import reactor.core.publisher.Mono;

public interface FetchCollector {
  Mono<Collector> execute(final String username);
}
