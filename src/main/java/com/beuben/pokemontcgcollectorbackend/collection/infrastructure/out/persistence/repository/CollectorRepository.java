package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.repository;

import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.entity.CollectorEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface CollectorRepository extends ReactiveCrudRepository<CollectorEntity, Long> {
  Mono<CollectorEntity> findByUsername(String username);
}
