package com.beuben.pokemontcgcollectorbackend.collection.application.port.in.fetch;

import com.beuben.pokemontcgcollectorbackend.collection.domain.Sealed;
import reactor.core.publisher.Flux;

public interface FetchAllCollectorSealed {
  Flux<Sealed> execute(Long collectorId);
}
