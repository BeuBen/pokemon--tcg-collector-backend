package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.adapter;

import com.beuben.pokemontcgcollectorbackend.collection.application.port.out.provider.CardProvider;
import com.beuben.pokemontcgcollectorbackend.collection.domain.Card;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.mapper.CardMapper;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.repository.CardRepository;
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
public class CardAdapter implements CardProvider {
  private static final Logger LOGGER = LoggerFactory.getLogger(CardAdapter.class);

  private final CardRepository repository;
  private final CardMapper mapper;

  @Override
  public Flux<Card> findAll() {
    return repository.findAll()
        .map(mapper::toCard);
  }

  @Override
  public Mono<Void> saveAll(Set<Card> cards) {
    LOGGER.info("Saving {} cards in database", cards.size());

    final var entities =
        cards.stream()
            .map(mapper::toEntity)
            .collect(Collectors.toSet());

    final var toSave = Flux.fromIterable(entities);
    return repository.saveAll(toSave)
        .then();
  }

  @Override
  public Mono<Void> deleteAll(Set<Card> cards) {
    LOGGER.info("Deleting {} cards from database", cards.size());

    final var entities =
        cards.stream()
            .map(mapper::toEntity)
            .collect(Collectors.toSet());

    final var toDelete = Flux.fromIterable(entities);
    return repository.deleteAll(toDelete)
        .then();
  }
}
