package com.beuben.pokemontcgcollectorbackend.synchronization.infrastructure.out.persistence.repository;

import com.beuben.pokemontcgcollectorbackend.synchronization.infrastructure.out.persistence.entity.CardEntity;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface CardRepository extends ReactiveCrudRepository<CardEntity, String> {
}
