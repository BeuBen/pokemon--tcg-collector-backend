package com.beuben.pokemontcgcollectorbackend.collection.application.port.out;

import com.beuben.pokemontcgcollectorbackend.collection.domain.MasterSet;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MasterSetProvider {
  Flux<MasterSet> findAllByCollectorId(Long collectorId);

  Mono<MasterSet> findById(Long id);

  Mono<MasterSet> add(MasterSet masterSet);
}
