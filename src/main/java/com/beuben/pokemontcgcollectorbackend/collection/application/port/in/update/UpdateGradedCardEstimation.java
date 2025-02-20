package com.beuben.pokemontcgcollectorbackend.collection.application.port.in.update;

import com.beuben.pokemontcgcollectorbackend.collection.domain.Estimation;
import com.beuben.pokemontcgcollectorbackend.collection.domain.GradedCard;
import reactor.core.publisher.Mono;

public interface UpdateGradedCardEstimation {
  Mono<GradedCard> execute(Long id, Estimation estimation);
}
