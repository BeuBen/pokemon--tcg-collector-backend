package com.beuben.pokemontcgcollectorbackend.collection.application.port.in.fetch;

import com.beuben.pokemontcgcollectorbackend.collection.domain.MasterSet;
import reactor.core.publisher.Mono;

public interface FetchMasterSet {
  Mono<MasterSet> execute(Long id);
}
