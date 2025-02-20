package com.beuben.pokemontcgcollectorbackend.collection.application.port.in.fetch;

import com.beuben.pokemontcgcollectorbackend.collection.domain.Item;
import reactor.core.publisher.Flux;

public interface FetchAllCollectorItems {
  Flux<Item> execute(Long collectorId);
}
