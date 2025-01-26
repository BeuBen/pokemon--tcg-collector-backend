package com.beuben.pokemontcgcollectorbackend.collection.application.port.out;

import com.beuben.pokemontcgcollectorbackend.collection.domain.Item;
import reactor.core.publisher.Flux;

public interface ItemProvider {
  Flux<Item> findAllByCollectorId(Long collectorId);
}
