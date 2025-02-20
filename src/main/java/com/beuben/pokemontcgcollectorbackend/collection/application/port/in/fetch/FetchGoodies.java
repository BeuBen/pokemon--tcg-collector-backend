package com.beuben.pokemontcgcollectorbackend.collection.application.port.in.fetch;

import com.beuben.pokemontcgcollectorbackend.collection.domain.Goodies;
import reactor.core.publisher.Mono;

public interface FetchGoodies {
  Mono<Goodies> execute(Long id);
}
