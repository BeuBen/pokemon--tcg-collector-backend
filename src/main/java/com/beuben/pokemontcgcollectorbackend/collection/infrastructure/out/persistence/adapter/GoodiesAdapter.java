package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.adapter;

import com.beuben.pokemontcgcollectorbackend.collection.application.port.out.GoodiesProvider;
import com.beuben.pokemontcgcollectorbackend.collection.domain.Goodies;
import com.beuben.pokemontcgcollectorbackend.collection.domain.exception.GoodiesNotFoundException;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.mapper.GoodiesMapper;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.repository.GoodiesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

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

  @Override
  public Mono<Goodies> findById(Long id) {
    return repository.findById(id)
        .map(mapper::toDomain)
        .switchIfEmpty(Mono.error(new GoodiesNotFoundException()));
  }

  @Override
  public Mono<Goodies> add(Goodies goodies) {
    final var now = LocalDateTime.now();

    final var gradedCardEntity =
        mapper.toEntity(goodies
            .withCreationDate(now)
            .withEstimation(goodies.getEstimation().withDate(now)));

    return repository.save(gradedCardEntity)
        .map(mapper::toDomain);
  }

  @Override
  public Mono<Goodies> update(Goodies goodies) {
    final var toSave = mapper.toEntity(goodies);

    return repository.save(toSave)
        .map(mapper::toDomain);
  }
}
