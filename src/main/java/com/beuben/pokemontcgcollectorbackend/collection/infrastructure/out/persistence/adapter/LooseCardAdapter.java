package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.adapter;

import com.beuben.pokemontcgcollectorbackend.collection.application.port.out.LooseCardProvider;
import com.beuben.pokemontcgcollectorbackend.collection.domain.LooseCard;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.mapper.LooseCardMapper;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.repository.LooseCardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class LooseCardAdapter implements LooseCardProvider {
  private final LooseCardRepository repository;
  private final LooseCardMapper mapper;

  @Override
  public Flux<LooseCard> findAllByCollectorId(Long collectorId) {
    return repository.findAllByCollectorId(collectorId)
        .map(mapper::toDomain);
  }

  @Override
  public Mono<LooseCard> add(LooseCard looseCard) {
    final var now = LocalDateTime.now();

    final var looseCardEntity =
        mapper.toEntity(looseCard
            .withCreationDate(now)
            .withEstimation(looseCard.getEstimation().withDate(now)));

    return repository.save(looseCardEntity)
        .map(mapper::toDomain);
  }
}
