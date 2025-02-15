package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.repository;

import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.entity.LooseCardEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface LooseCardRepository extends ReactiveCrudRepository<LooseCardEntity, Long> {
  Flux<LooseCardEntity> findAllByCollectorId(Long collectorId);
}
