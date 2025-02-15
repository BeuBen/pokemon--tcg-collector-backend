package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.adapter;

import com.beuben.pokemontcgcollectorbackend.collection.application.port.out.GradedCardProvider;
import com.beuben.pokemontcgcollectorbackend.collection.domain.GradedCard;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.mapper.GradedCardMapper;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.repository.GradedCardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

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
}
