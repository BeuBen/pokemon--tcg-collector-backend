package com.beuben.pokemontcgcollectorbackend.synchronization.infrastructure.out.persistence.adapter;

import com.beuben.pokemontcgcollectorbackend.synchronization.application.port.out.provider.CardProvider;
import com.beuben.pokemontcgcollectorbackend.synchronization.application.port.out.provider.RefreshProvider;
import com.beuben.pokemontcgcollectorbackend.synchronization.domain.card.Card;
import com.beuben.pokemontcgcollectorbackend.synchronization.infrastructure.out.persistence.entity.CardEntity;
import com.beuben.pokemontcgcollectorbackend.synchronization.infrastructure.out.persistence.mapper.CardMapper;
import com.beuben.pokemontcgcollectorbackend.synchronization.infrastructure.out.persistence.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class RefreshAdapter implements RefreshProvider {
  private static final Logger LOGGER = LoggerFactory.getLogger(RefreshAdapter.class);

  @Qualifier("externalCardAdapter") private final CardProvider externalCardProvider;
  @Qualifier("persistenceCardAdapter") private final CardProvider persistenceCardProvider;
  private final CardRepository cardRepository;
  private final CardMapper cardMapper;

  @Override
  public Mono<Void> refreshCards() {
    final var existingCards =
        externalCardProvider.findAll()
            .collect(Collectors.toSet());
    final var persistedCards =
        persistenceCardProvider.findAll()
            .collect(Collectors.toSet());

    return Mono.zip(existingCards, persistedCards)
        .flatMap(this::differentiateAndPersistFromTuple);
  }

  private Mono<Void> differentiateAndPersistFromTuple(Tuple2<Set<Card>, Set<Card>> existingAndPersistingCardsTuple) {
    var existing = existingAndPersistingCardsTuple.getT1();
    var persisted = existingAndPersistingCardsTuple.getT2();

    final var toCreate =
        existing.stream()
            .filter(card -> !card.isInSet(persisted))
            .map(cardMapper::toEntity)
            .collect(Collectors.toSet());

    final var toDelete = persisted.stream()
        .filter(card -> !card.isInSet(existing))
        .map(cardMapper::toEntity)
        .collect(Collectors.toSet());

    return Mono.when(
        saveAll(toCreate),
        deleteAll(toDelete));
  }

  private Mono<Void> saveAll(Set<CardEntity> cards) {
    LOGGER.info("Saving {} cards in database", cards.size());

    final var toSave = Flux.fromIterable(cards);
    return cardRepository.saveAll(toSave)
        .then();
  }

  private Mono<Void> deleteAll(Set<CardEntity> cards) {
    LOGGER.info("Deleting {} cards from database", cards.size());

    final var toDelete = Flux.fromIterable(cards);
    return cardRepository.deleteAll(toDelete)
        .then();
  }
}
