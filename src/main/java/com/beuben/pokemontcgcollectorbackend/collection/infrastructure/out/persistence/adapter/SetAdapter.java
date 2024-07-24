package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.adapter;

import com.beuben.pokemontcgcollectorbackend.collection.application.port.out.provider.SetProvider;
import com.beuben.pokemontcgcollectorbackend.collection.domain.CardSet;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.mapper.SetMapper;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.repository.SetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
@RequiredArgsConstructor
public class SetAdapter implements SetProvider {
  private final SetRepository repository;
  private final SetMapper mapper;

  @Override
  public Flux<CardSet> findAll() {
    return repository.findAll()
        .map(mapper::toCardSet);
  }
}
