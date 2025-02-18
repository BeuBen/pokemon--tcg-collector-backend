package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.adapter;

import com.beuben.pokemontcgcollectorbackend.collection.application.port.out.MasterSetProvider;
import com.beuben.pokemontcgcollectorbackend.collection.domain.MasterSet;
import com.beuben.pokemontcgcollectorbackend.collection.domain.exception.MasterSetNotFoundException;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.mapper.MasterSetMapper;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.repository.MasterSetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class MasterSetAdapter implements MasterSetProvider {
  private final MasterSetRepository repository;
  private final MasterSetMapper mapper;

  @Override
  public Flux<MasterSet> findAllByCollectorId(Long collectorId) {
    return repository.findAllByCollectorId(collectorId)
        .map(mapper::toDomain);
  }

  @Override
  public Mono<MasterSet> findById(Long id) {
    return repository.findById(id)
        .map(mapper::toDomain)
        .switchIfEmpty(Mono.error(new MasterSetNotFoundException()));
  }

  @Override
  public Mono<MasterSet> add(MasterSet masterSet) {
    final var now = LocalDateTime.now();

    final var masterSetEntity =
        mapper.toEntity(masterSet
            .withCreationDate(now)
            .withEstimation(masterSet.getEstimation().withDate(now)));

    return repository.save(masterSetEntity)
        .map(mapper::toDomain);
  }
}
