package com.beuben.pokemontcgcollectorbackend.collection.application.port.in.add;

import com.beuben.pokemontcgcollectorbackend.collection.domain.MasterSet;
import reactor.core.publisher.Mono;

public interface AddMasterSetToCollection {
  Mono<MasterSet> execute(MasterSet masterSet);
}
