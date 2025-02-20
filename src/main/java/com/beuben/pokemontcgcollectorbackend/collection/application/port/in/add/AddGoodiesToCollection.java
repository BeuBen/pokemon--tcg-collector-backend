package com.beuben.pokemontcgcollectorbackend.collection.application.port.in.add;

import com.beuben.pokemontcgcollectorbackend.collection.domain.Goodies;
import reactor.core.publisher.Mono;

public interface AddGoodiesToCollection {
  Mono<Goodies> execute(Goodies goodies);
}
