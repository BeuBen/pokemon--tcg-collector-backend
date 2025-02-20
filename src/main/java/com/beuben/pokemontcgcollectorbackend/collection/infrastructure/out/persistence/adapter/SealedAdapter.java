package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.adapter;

import com.beuben.pokemontcgcollectorbackend.collection.application.port.out.SealedProvider;
import com.beuben.pokemontcgcollectorbackend.collection.domain.Sealed;
import com.beuben.pokemontcgcollectorbackend.collection.domain.exception.SealedNotFoundException;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.mapper.SealedMapper;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.repository.SealedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class SealedAdapter implements SealedProvider {
  private final SealedRepository repository;
  private final SealedMapper mapper;

  @Override
  public Flux<Sealed> findAllByCollectorId(Long collectorId) {
    return repository.findAllByCollectorId(collectorId)
        .map(mapper::toDomain);
  }

  @Override
  public Mono<Sealed> findById(Long id) {
    return repository.findById(id)
        .map(mapper::toDomain)
        .switchIfEmpty(Mono.error(new SealedNotFoundException()));
  }

  @Override
  public Mono<Sealed> add(Sealed sealed) {
    final var now = LocalDateTime.now();

    final var sealedEntity =
        mapper.toEntity(sealed
            .withCreationDate(now)
            .withEstimation(sealed.getEstimation().withDate(now)));

    return repository.save(sealedEntity)
        .map(mapper::toDomain);
  }

  @Override
  public Mono<Sealed> update(Sealed sealed) {
    final var toSave = mapper.toEntity(sealed);

    return repository.save(toSave)
        .map(mapper::toDomain);
  }
}
