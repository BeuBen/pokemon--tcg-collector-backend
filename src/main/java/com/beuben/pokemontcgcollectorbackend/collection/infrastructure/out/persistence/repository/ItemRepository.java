package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.repository;

import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.entity.ItemEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface ItemRepository extends ReactiveCrudRepository<ItemEntity, Long> {
  Flux<ItemEntity> findAllByCollectorId(Long collectorId);
}
