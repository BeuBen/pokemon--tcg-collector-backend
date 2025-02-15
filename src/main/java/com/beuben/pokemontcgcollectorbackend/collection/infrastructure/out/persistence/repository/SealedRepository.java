package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.repository;

import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.entity.SealedEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface SealedRepository extends ReactiveCrudRepository<SealedEntity, Long> {
  Flux<SealedEntity> findAllByCollectorId(Long collectorId);
}
