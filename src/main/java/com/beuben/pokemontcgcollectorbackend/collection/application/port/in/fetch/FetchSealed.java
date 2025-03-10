package com.beuben.pokemontcgcollectorbackend.collection.application.port.in.fetch;

import com.beuben.pokemontcgcollectorbackend.collection.domain.Sealed;
import reactor.core.publisher.Mono;

public interface FetchSealed {
  Mono<Sealed> execute(Long id);
}
