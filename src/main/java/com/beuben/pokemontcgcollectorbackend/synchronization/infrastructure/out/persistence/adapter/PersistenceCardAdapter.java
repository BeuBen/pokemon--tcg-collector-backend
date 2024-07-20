package com.beuben.pokemontcgcollectorbackend.synchronization.infrastructure.out.persistence.adapter;

import com.beuben.pokemontcgcollectorbackend.synchronization.application.port.out.provider.CardProvider;
import com.beuben.pokemontcgcollectorbackend.synchronization.domain.card.Card;
import com.beuben.pokemontcgcollectorbackend.synchronization.infrastructure.out.persistence.mapper.CardMapper;
import com.beuben.pokemontcgcollectorbackend.synchronization.infrastructure.out.persistence.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
@RequiredArgsConstructor
@Qualifier("persistenceCardAdapter")
public class PersistenceCardAdapter implements CardProvider {
  private final CardRepository repository;
  private final CardMapper mapper;

  @Override
  public Flux<Card> findAll() {
    return repository.findAll()
        .map(mapper::toCard);
  }
}
