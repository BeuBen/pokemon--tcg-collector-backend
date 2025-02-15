package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.adapter;

import com.beuben.pokemontcgcollectorbackend.collection.application.port.out.GoodiesProvider;
import com.beuben.pokemontcgcollectorbackend.collection.domain.Goodies;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.mapper.GoodiesMapper;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.repository.GoodiesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
@RequiredArgsConstructor
public class GoodiesAdapter implements GoodiesProvider {
  private final GoodiesRepository repository;
  private final GoodiesMapper mapper;

  @Override
  public Flux<Goodies> findAllByCollectorId(Long collectorId) {
    return repository.findAllByCollectorId(collectorId)
        .map(mapper::toDomain);
  }
}
