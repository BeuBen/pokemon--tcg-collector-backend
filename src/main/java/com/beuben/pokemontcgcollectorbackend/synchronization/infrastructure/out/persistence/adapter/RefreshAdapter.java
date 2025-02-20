package com.beuben.pokemontcgcollectorbackend.synchronization.infrastructure.out.persistence.adapter;

import com.beuben.pokemontcgcollectorbackend.catalog.application.port.out.provider.CardProvider;
import com.beuben.pokemontcgcollectorbackend.catalog.application.port.out.provider.SetProvider;
import com.beuben.pokemontcgcollectorbackend.catalog.domain.Card;
import com.beuben.pokemontcgcollectorbackend.catalog.domain.CardSet;
import com.beuben.pokemontcgcollectorbackend.synchronization.application.port.out.provider.ExistingCardProvider;
import com.beuben.pokemontcgcollectorbackend.synchronization.application.port.out.provider.ExistingSetProvider;
import com.beuben.pokemontcgcollectorbackend.synchronization.application.port.out.provider.RefreshProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;
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
    return existingCardProvider.findAll()
        .collectList()
        .flatMap(existing -> cardProvider.findAll()
            .collectList()
            .flatMap(persisted -> differentiateAndPersistCards(existing, persisted))
        );
  }

  private Mono<Void> differentiateAndPersistCards(List<Card> existing, List<Card> persisted) {
    final var toCreate =
        existing.stream()
            .filter(card -> !card.isInList(persisted))
            .collect(Collectors.toSet());

    final var toDelete = persisted.stream()
        .filter(card -> !card.isInList(existing))
        .collect(Collectors.toSet());

    return Mono.when(
        cardProvider.saveAll(toCreate),
        cardProvider.deleteAll(toDelete));
  }

  @Override
  public Mono<Void> refreshSets() {
    return existingSetProvider.findAll()
        .collectList()
        .flatMap(existing -> setProvider.findAll()
            .collectList()
            .flatMap(persisted -> differentiateAndPersistSets(existing, persisted))
        );
  }

  private Mono<Void> differentiateAndPersistSets(List<CardSet> existing, List<CardSet> persisted) {
    final var toCreate =
        existing.stream()
            .filter(cardSet -> !cardSet.isInList(persisted))
            .collect(Collectors.toSet());

    final var toDelete = persisted.stream()
        .filter(cardSet -> !cardSet.isInList(existing))
        .collect(Collectors.toSet());

    return Mono.when(
        setProvider.saveAll(toCreate),
        setProvider.deleteAll(toDelete));
  }
}
