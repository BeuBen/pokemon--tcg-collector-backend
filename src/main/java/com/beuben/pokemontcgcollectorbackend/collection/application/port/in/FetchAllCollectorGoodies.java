package com.beuben.pokemontcgcollectorbackend.collection.application.port.in;

import com.beuben.pokemontcgcollectorbackend.collection.domain.Goodies;
import reactor.core.publisher.Flux;

public interface FetchAllCollectorGoodies {
  Flux<Goodies> execute(Long collectorId);
}
