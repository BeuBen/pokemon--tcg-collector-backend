package com.beuben.pokemontcgcollectorbackend.synchronization.application.port.in;

import reactor.core.publisher.Mono;

public interface RefreshSets {
  Mono<Void> execute();
}
