package com.beuben.pokemontcgcollectorbackend.collection.application.port.in.fetch;

import com.beuben.pokemontcgcollectorbackend.collection.domain.MasterSet;
import reactor.core.publisher.Flux;

public interface FetchAllCollectorMasterSets {
  Flux<MasterSet> execute(Long collectorId);
}
