package com.beuben.pokemontcgcollectorbackend.collection.application.port.in.update;

import com.beuben.pokemontcgcollectorbackend.collection.domain.Estimation;
import com.beuben.pokemontcgcollectorbackend.collection.domain.MasterSet;
import reactor.core.publisher.Mono;

public interface UpdateMasterSetEstimation {
  Mono<MasterSet> execute(Long id, Estimation estimation);
}
