package com.beuben.pokemontcgcollectorbackend.collection.application.port.out;

import com.beuben.pokemontcgcollectorbackend.collection.domain.LooseCard;
import reactor.core.publisher.Flux;

public interface LooseCardProvider {
  Flux<LooseCard> findAllByCollectorId(Long collectorId);
}
