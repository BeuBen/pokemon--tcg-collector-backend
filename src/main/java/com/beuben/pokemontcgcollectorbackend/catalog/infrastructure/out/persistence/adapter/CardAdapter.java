package com.beuben.pokemontcgcollectorbackend.catalog.infrastructure.out.persistence.adapter;

import com.beuben.pokemontcgcollectorbackend.catalog.application.port.out.provider.CardProvider;
import com.beuben.pokemontcgcollectorbackend.catalog.application.port.out.provider.SetProvider;
import com.beuben.pokemontcgcollectorbackend.catalog.domain.Card;
import com.beuben.pokemontcgcollectorbackend.catalog.domain.CardSet;
import com.beuben.pokemontcgcollectorbackend.catalog.infrastructure.out.persistence.entity.CardEntity;
import com.beuben.pokemontcgcollectorbackend.catalog.infrastructure.out.persistence.mapper.CardMapper;
import com.beuben.pokemontcgcollectorbackend.catalog.infrastructure.out.persistence.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CardAdapter implements CardProvider {
  private static final Logger LOGGER = LoggerFactory.getLogger(CardAdapter.class);

  private final SetProvider setProvider;
  private final CardRepository repository;
  private final CardMapper mapper;

  @Override
  public Flux<Card> findAll() {
    return repository.findAll()
        .map(mapper::toCard);
  }

  @Override
  public Mono<Void> saveAll(final Set<Card> cards) {
    LOGGER.info("Saving {} cards in database", cards.size());

    return setProvider.findAll()
        .collectList()
        .flatMapMany(cardSets -> Flux.fromIterable(completeDataAndMapToEntities(cards, cardSets)))
        .flatMap(repository::save)
        .then();
  }

  private Set<CardEntity> completeDataAndMapToEntities(
      final Set<Card> cardsToComplete,
      final List<CardSet> extensions) {
    // List all extension codes from the list of cardsToComplete
    final var extensionCodes =
        cardsToComplete.stream()
            .map(card -> card.getSet().getCode())
            .collect(Collectors.toSet());

    // Map all existing extensions to their associated code
    final Map<String, CardSet> extensionCodeToExtension =
        extensions.stream()
            .collect(Collectors.toMap(
                CardSet::getCode,
                set -> set));

    // Keep only extensions from which cardsToComplete (initial parameter) come from
    final Map<String, CardSet> concernedExtensions =
        extensionCodeToExtension.entrySet().stream()
            .filter(entry -> extensionCodes.contains(entry.getKey()))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    return cardsToComplete.stream()
        .map(card -> card.withCompletedSetFromSetMap(concernedExtensions))
        .map(mapper::toEntity)
        .collect(Collectors.toSet());
  }

  @Override
  public Mono<Void> deleteAll(final Set<Card> cards) {
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
