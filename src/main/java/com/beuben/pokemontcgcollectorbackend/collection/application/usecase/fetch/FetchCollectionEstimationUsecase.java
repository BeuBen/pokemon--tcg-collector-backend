package com.beuben.pokemontcgcollectorbackend.collection.application.usecase.fetch;

import com.beuben.pokemontcgcollectorbackend.collection.application.port.in.fetch.FetchCollectionEstimation;
import com.beuben.pokemontcgcollectorbackend.collection.application.port.out.*;
import com.beuben.pokemontcgcollectorbackend.collection.domain.*;
import com.beuben.pokemontcgcollectorbackend.collection.domain.exception.CollectorNotFoundException;
import com.beuben.pokemontcgcollectorbackend.core.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple5;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
public class FetchCollectionEstimationUsecase implements FetchCollectionEstimation {
  private final CollectorProvider collectorProvider;
  private final GoodiesProvider goodiesProvider;
  private final GradedCardProvider gradedCardProvider;
  private final LooseCardProvider looseCardProvider;
  private final MasterSetProvider masterSetProvider;
  private final SealedProvider sealedProvider;

  @Override
  public Mono<CollectionEstimation> execute(Long collectorId) {
    return collectorProvider.findById(collectorId)
        .flatMap(this::fetchItemsAndCountEstimation)
        .onErrorMap(CollectorNotFoundException.class,
            _ -> new NotFoundException(Collector.class, collectorId));
  }

  private Mono<CollectionEstimation> fetchItemsAndCountEstimation(Collector collector) {
    final var goodies = goodiesProvider.findAllByCollectorId(collector.getId())
        .collectList();
    final var gradedCards = gradedCardProvider.findAllByCollectorId(collector.getId())
        .collectList();
    final var looseCards = looseCardProvider.findAllByCollectorId(collector.getId())
        .collectList();
    final var masterSets = masterSetProvider.findAllByCollectorId(collector.getId())
        .collectList();
    final var sealedItems = sealedProvider.findAllByCollectorId(collector.getId())
        .collectList();

    return Mono.zip(goodies, gradedCards, looseCards, masterSets, sealedItems)
        .flatMap(this::getTotalEstimationFromTuple);
  }

  private Mono<CollectionEstimation> getTotalEstimationFromTuple(
      Tuple5<List<Goodies>, List<GradedCard>, List<LooseCard>, List<MasterSet>, List<Sealed>> tuple) {
    final var goodies = tuple.getT1();
    final var gradedCards = tuple.getT2();
    final var looseCards = tuple.getT3();
    final var masterSets = tuple.getT4();
    final var sealedItems = tuple.getT5();

    final var gradedCardsFromMasterSets = gradedCards.stream()
        .filter(GradedCard::isFromMasterSet)
        .toList();

    final var gradedCardsNotFromMasterSets = gradedCards.stream()
        .filter(gradedCard -> !gradedCard.isFromMasterSet())
        .toList();

    final var looseCardsFromMasterSets = looseCards.stream()
        .filter(LooseCard::isFromMasterSet)
        .toList();

    final var looseCardsNotFromMasterSets = looseCards.stream()
        .filter(looseCard -> !looseCard.isFromMasterSet())
        .toList();

    final var goodiesValue =
        goodies.stream()
            .map(item -> item.getEstimation().getPriceInEuros())
            .reduce(BigDecimal.ZERO, BigDecimal::add);

    final var sealedItemsValue =
        sealedItems.stream()
            .map(Sealed::getRelativeEstimationInEuros)
            .reduce(BigDecimal.ZERO, BigDecimal::add);

    final var gradedCardsValue =
        gradedCardsNotFromMasterSets.stream()
            .map(item -> item.getEstimation().getPriceInEuros())
            .reduce(BigDecimal.ZERO, BigDecimal::add);

    final var looseCardsValue =
        looseCardsNotFromMasterSets.stream()
            .map(item -> item.getEstimation().getPriceInEuros())
            .reduce(BigDecimal.ZERO, BigDecimal::add);

    final Map<Long, List<GradedCard>> masterSetIdsAndGradedCards =
        gradedCardsFromMasterSets.stream()
            .collect(Collectors.groupingBy(GradedCard::getMasterSetId));

    final Map<Long, List<LooseCard>> masterSetIdsAndLooseCards =
        looseCardsFromMasterSets.stream()
            .collect(Collectors.groupingBy(LooseCard::getMasterSetId));

    final var masterSetsValue =
        getMasterSetsTotalEstimation(
            masterSets,
            masterSetIdsAndLooseCards,
            masterSetIdsAndGradedCards);

    final var collectionValue =
        Stream.of(goodiesValue, gradedCardsValue, looseCardsValue, masterSetsValue, sealedItemsValue)
            .reduce(BigDecimal.ZERO, BigDecimal::add);

    final var collectionEstimationDetail =
        Map.of(
            ItemType.GRADED_CARD,
            new CollectionEstimationDetail(gradedCardsNotFromMasterSets.size(), gradedCardsValue),
            ItemType.GOODIES,
            new CollectionEstimationDetail(goodies.size(), goodiesValue),
            ItemType.LOOSE_CARD,
            new CollectionEstimationDetail(looseCardsNotFromMasterSets.size(), looseCardsValue),
            ItemType.MASTER_SET,
            new CollectionEstimationDetail(masterSets.size(), masterSetsValue),
            ItemType.SEALED,
            new CollectionEstimationDetail(sealedItems.size(), sealedItemsValue));

    return Mono.just(new CollectionEstimation(collectionValue, collectionEstimationDetail));
  }

  private BigDecimal getMasterSetsTotalEstimation(
      List<MasterSet> masterSets,
      Map<Long, List<LooseCard>> looseCardsFromMasterSets,
      Map<Long, List<GradedCard>> gradedCardsFromMasterSets) {

    return masterSets.stream()
        .map(masterSet ->
            extractAndGetSingleMasterSetEstimation(looseCardsFromMasterSets, gradedCardsFromMasterSets, masterSet))
        .reduce(BigDecimal.ZERO, BigDecimal::add);
  }

  private BigDecimal extractAndGetSingleMasterSetEstimation(
      Map<Long, List<LooseCard>> looseCardsFromMasterSets,
      Map<Long, List<GradedCard>> gradedCardsFromMasterSets,
      MasterSet masterSet) {
    final var looseCardsFromThisMasterSet =
        Optional.ofNullable(looseCardsFromMasterSets.get(masterSet.getId()))
            .orElse(Collections.emptyList());
    final var gradedCardsFromThisMasterSet =
        Optional.ofNullable(gradedCardsFromMasterSets.get(masterSet.getId()))
            .orElse(Collections.emptyList());

    return masterSet.getRelativeEstimationInEuros(
        gradedCardsFromThisMasterSet,
        looseCardsFromThisMasterSet);
  }
}
