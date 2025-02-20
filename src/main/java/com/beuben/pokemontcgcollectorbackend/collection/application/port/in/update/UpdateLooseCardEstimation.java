package com.beuben.pokemontcgcollectorbackend.collection.application.port.in.update;

import com.beuben.pokemontcgcollectorbackend.collection.domain.Estimation;
import com.beuben.pokemontcgcollectorbackend.collection.domain.LooseCard;
import reactor.core.publisher.Mono;

public interface UpdateLooseCardEstimation {
  Mono<LooseCard> execute(Long id, Estimation estimation);
}
