package com.beuben.pokemontcgcollectorbackend.synchronization.application.port.in;

import reactor.core.publisher.Mono;

public interface RefreshCards {
  Mono<Void> execute();
}
