package com.beuben.pokemontcgcollectorbackend.synchronization.infrastructure.out.persistence.adapter;

import com.beuben.pokemontcgcollectorbackend.collection.application.port.out.provider.CardProvider;
import com.beuben.pokemontcgcollectorbackend.collection.application.port.out.provider.SetProvider;
import com.beuben.pokemontcgcollectorbackend.collection.domain.Card;
import com.beuben.pokemontcgcollectorbackend.collection.domain.CardSet;
import com.beuben.pokemontcgcollectorbackend.synchronization.application.port.out.provider.ExistingCardProvider;
import com.beuben.pokemontcgcollectorbackend.synchronization.application.port.out.provider.ExistingSetProvider;
import com.beuben.pokemontcgcollectorbackend.synchronization.application.port.out.provider.RefreshProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class RefreshAdapter implements RefreshProvider {
  private final ExistingCardProvider existingCardProvider;
  private final ExistingSetProvider existingSetProvider;
  private final CardProvider cardProvider;
  private final SetProvider setProvider;

  @Override
  public Mono<Void> refreshCards() {
    final var existingCards =
        existingCardProvider.findAll()
            .collect(Collectors.toSet());
    final var persistedCards =
        cardProvider.findAll()
            .collect(Collectors.toSet());

    return Mono.zip(existingCards, persistedCards)
        .flatMap(this::differentiateAndPersistCardsFromTuple);
  }

  private Mono<Void> differentiateAndPersistCardsFromTuple(Tuple2<Set<Card>, Set<Card>> existingAndPersistingCardsTuple) {
    var existing = existingAndPersistingCardsTuple.getT1();
    var persisted = existingAndPersistingCardsTuple.getT2();

    final var toCreate =
        existing.stream()
            .filter(card -> !card.isInSet(persisted))
            .collect(Collectors.toSet());

    final var toDelete = persisted.stream()
        .filter(card -> !card.isInSet(existing))
        .collect(Collectors.toSet());

    return Mono.when(
        cardProvider.saveAll(toCreate),
        cardProvider.deleteAll(toDelete));
  }

  @Override
  public Mono<Void> refreshSets() {
    final var existingSets =
        existingSetProvider.findAll()
            .collect(Collectors.toSet());
    final var persistedSets =
        setProvider.findAll()
            .collect(Collectors.toSet());

    return Mono.zip(existingSets, persistedSets)
        .flatMap(this::differentiateAndPersistSetsFromTuple);
  }

  private Mono<Void> differentiateAndPersistSetsFromTuple(Tuple2<Set<CardSet>, Set<CardSet>> existingAndPersistingSetsTuple) {
    var existing = existingAndPersistingSetsTuple.getT1();
    var persisted = existingAndPersistingSetsTuple.getT2();

    final var toCreate =
        existing.stream()
            .filter(cardSet -> !cardSet.isInSet(persisted))
            .collect(Collectors.toSet());

    final var toDelete = persisted.stream()
        .filter(cardSet -> !cardSet.isInSet(existing))
        .collect(Collectors.toSet());

    return Mono.when(
        setProvider.saveAll(toCreate),
        setProvider.deleteAll(toDelete));
  }
}
