package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.adapter;

import com.beuben.pokemontcgcollectorbackend.collection.application.port.out.ItemProvider;
import com.beuben.pokemontcgcollectorbackend.collection.domain.Item;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.mapper.ItemMapper;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
@RequiredArgsConstructor
public class ItemAdapter implements ItemProvider {
  private final ItemRepository repository;
  private final ItemMapper mapper;

  @Override
  public Flux<Item> findAllByCollectorId(Long collectorId) {
    return repository.findAllByCollectorId(collectorId)
        .map(mapper::toDomain);
  }
}
