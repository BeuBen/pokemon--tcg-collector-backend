package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.repository;

import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.entity.GoodiesEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface GoodiesRepository extends ReactiveCrudRepository<GoodiesEntity, Long> {
  Flux<GoodiesEntity> findAllByCollectorId(Long collectorId);
}
