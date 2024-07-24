package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.adapter;

import com.beuben.pokemontcgcollectorbackend.collection.application.port.out.provider.CardProvider;
import com.beuben.pokemontcgcollectorbackend.collection.domain.Card;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.mapper.CardMapper;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
@RequiredArgsConstructor
public class CardAdapter implements CardProvider {
  private final CardRepository repository;
  private final CardMapper mapper;

  @Override
  public Flux<Card> findAll() {
    return repository.findAll()
        .map(mapper::toCard);
  }
}
