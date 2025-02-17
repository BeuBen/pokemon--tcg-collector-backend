package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.adapter;

import com.beuben.pokemontcgcollectorbackend.collection.application.port.out.GradedCardProvider;
import com.beuben.pokemontcgcollectorbackend.collection.domain.GradedCard;
import com.beuben.pokemontcgcollectorbackend.collection.domain.exception.GradedCardNotFoundException;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.mapper.GradedCardMapper;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.repository.GradedCardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class GradedCardAdapter implements GradedCardProvider {
  private final GradedCardRepository repository;
  private final GradedCardMapper mapper;

  @Override
  public Flux<GradedCard> findAllByCollectorId(Long collectorId) {
    return repository.findAllByCollectorId(collectorId)
        .map(mapper::toDomain);
  }

  @Override
  public Mono<GradedCard> findById(Long id) {
    return repository.findById(id)
        .map(mapper::toDomain)
        .switchIfEmpty(Mono.error(new GradedCardNotFoundException()));
  }

  @Override
  public Mono<GradedCard> add(GradedCard gradedCard) {
    final var now = LocalDateTime.now();

    final var gradedCardEntity =
        mapper.toEntity(gradedCard
            .withCreationDate(now)
            .withEstimation(gradedCard.getEstimation().withDate(now)));

    return repository.save(gradedCardEntity)
        .map(mapper::toDomain);
  }
}
