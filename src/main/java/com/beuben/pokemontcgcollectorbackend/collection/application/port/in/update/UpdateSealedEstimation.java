package com.beuben.pokemontcgcollectorbackend.collection.application.port.in.update;

import com.beuben.pokemontcgcollectorbackend.collection.domain.Estimation;
import com.beuben.pokemontcgcollectorbackend.collection.domain.Sealed;
import reactor.core.publisher.Mono;

public interface UpdateSealedEstimation {
  Mono<Sealed> execute(Long id, Estimation estimation);
}
