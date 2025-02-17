package com.beuben.pokemontcgcollectorbackend.collection.application.port.in;

import com.beuben.pokemontcgcollectorbackend.collection.domain.LooseCard;
import reactor.core.publisher.Flux;

public interface FetchAllCollectorLooseCards {
  Flux<LooseCard> execute(Long collectorId);
}
