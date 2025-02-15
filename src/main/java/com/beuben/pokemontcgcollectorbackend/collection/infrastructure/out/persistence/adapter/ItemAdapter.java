package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.adapter;

import com.beuben.pokemontcgcollectorbackend.collection.application.port.out.*;
import com.beuben.pokemontcgcollectorbackend.collection.domain.*;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.mapper.ItemMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple5;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
public class ItemAdapter implements ItemProvider {
  private final GradedCardProvider gradedCardProvider;
  private final GoodiesProvider goodiesProvider;
  private final LooseCardProvider looseCardProvider;
  private final MasterSetProvider masterSetProvider;
  private final SealedProvider sealedProvider;
  private final ItemMapper mapper;

  @Override
  public Flux<Item> findAllByCollectorId(Long collectorId) {
    final var gradedCards = gradedCardProvider.findAllByCollectorId(collectorId)
        .collectList();
    final var goodies = goodiesProvider.findAllByCollectorId(collectorId)
        .collectList();
    final var looseCards = looseCardProvider.findAllByCollectorId(collectorId)
        .collectList();
    final var masterSets = masterSetProvider.findAllByCollectorId(collectorId)
        .collectList();
    final var sealedItems = sealedProvider.findAllByCollectorId(collectorId)
        .collectList();

    return Mono.zip(gradedCards, goodies, looseCards, masterSets, sealedItems)
        .flatMapMany(this::getMappedItems);
  }

  private Flux<Item> getMappedItems(Tuple5<List<GradedCard>, List<Goodies>, List<LooseCard>, List<MasterSet>, List<Sealed>> tuple) {
    final var allItems = Stream.of(
            tuple.getT1().stream().map(mapper::toItem),
            tuple.getT2().stream().map(mapper::toItem),
            tuple.getT3().stream().map(mapper::toItem),
            tuple.getT4().stream().map(mapper::toItem),
            tuple.getT5().stream().map(mapper::toItem))
        .flatMap(Function.identity())
        .toList();

    return Flux.fromIterable(allItems);
  }
}
