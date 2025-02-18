package com.beuben.pokemontcgcollectorbackend.collection.application.port.in;

import com.beuben.pokemontcgcollectorbackend.collection.domain.Sealed;
import reactor.core.publisher.Mono;

public interface AddSealedToCollection {
  Mono<Sealed> execute(Sealed sealed);
}
