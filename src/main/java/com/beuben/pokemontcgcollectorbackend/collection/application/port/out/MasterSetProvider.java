package com.beuben.pokemontcgcollectorbackend.collection.application.port.out;

import com.beuben.pokemontcgcollectorbackend.collection.domain.MasterSet;
import reactor.core.publisher.Flux;

public interface MasterSetProvider {
  Flux<MasterSet> findAllByCollectorId(Long collectorId);
}
