package com.beuben.pokemontcgcollectorbackend.collection.application.port.in.fetch;

import com.beuben.pokemontcgcollectorbackend.collection.domain.LooseCard;
import reactor.core.publisher.Mono;

public interface FetchLooseCard {
  Mono<LooseCard> execute(Long id);
}
