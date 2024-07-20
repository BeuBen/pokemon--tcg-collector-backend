package com.beuben.pokemontcgcollectorbackend.synchronization.application.port.out.provider;

import reactor.core.publisher.Mono;

public interface RefreshProvider {
  Mono<Void> refreshCards();
}
