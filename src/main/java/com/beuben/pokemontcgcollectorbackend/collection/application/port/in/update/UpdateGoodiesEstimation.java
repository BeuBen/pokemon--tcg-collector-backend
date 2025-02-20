package com.beuben.pokemontcgcollectorbackend.collection.application.port.in.update;

import com.beuben.pokemontcgcollectorbackend.collection.domain.Estimation;
import com.beuben.pokemontcgcollectorbackend.collection.domain.Goodies;
import reactor.core.publisher.Mono;

public interface UpdateGoodiesEstimation {
  Mono<Goodies> execute(Long id, Estimation estimation);
}
