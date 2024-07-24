package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.adapter;

import com.beuben.pokemontcgcollectorbackend.collection.application.port.out.provider.SetProvider;
import com.beuben.pokemontcgcollectorbackend.collection.domain.CardSet;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.mapper.SetMapper;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.repository.SetRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class SetAdapter implements SetProvider {
  private static final Logger LOGGER = LoggerFactory.getLogger(SetAdapter.class);

  private final SetRepository repository;
  private final SetMapper mapper;

  @Override
  public Flux<CardSet> findAll() {
    return repository.findAll()
        .map(mapper::toCardSet);
  }

  @Override
  public Mono<Void> saveAll(Set<CardSet> sets) {
    LOGGER.info("Saving {} sets in database", sets.size());

    final var entities =
        sets.stream()
            .map(mapper::toEntity)
            .collect(Collectors.toSet());

    final var toSave = Flux.fromIterable(entities);
    return repository.saveAll(toSave)
        .then();
  }

  @Override
  public Mono<Void> deleteAll(Set<CardSet> sets) {
    LOGGER.info("Deleting {} sets from database", sets.size());

    final var entities =
        sets.stream()
            .map(mapper::toEntity)
            .collect(Collectors.toSet());

    final var toDelete = Flux.fromIterable(entities);
    return repository.deleteAll(toDelete)
        .then();
  }
}
