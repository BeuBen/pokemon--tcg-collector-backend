package com.beuben.pokemontcgcollectorbackend.collection.application.port.in.fetch;

import com.beuben.pokemontcgcollectorbackend.collection.domain.GradedCard;
import reactor.core.publisher.Mono;

public interface FetchGradedCard {
  Mono<GradedCard> execute(Long id);
}
