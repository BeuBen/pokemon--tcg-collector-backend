package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.adapter;

import com.beuben.pokemontcgcollectorbackend.collection.application.port.out.CollectorProvider;
import com.beuben.pokemontcgcollectorbackend.collection.domain.Collector;
import com.beuben.pokemontcgcollectorbackend.collection.domain.exception.CollectorNotFoundException;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.mapper.CollectorMapper;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.repository.CollectorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class CollectorAdapter implements CollectorProvider {
  private final CollectorRepository repository;
  private final CollectorMapper mapper;

  @Override
  public Mono<Collector> findByUsername(final String username) {
    return repository.findByUsername(username)
        .map(mapper::toDomain)
        .switchIfEmpty(Mono.error(new CollectorNotFoundException()));
  }
}
