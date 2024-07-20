package com.beuben.pokemontcgcollectorbackend.synchronization.infrastructure.out.persistence.mapper;

import com.beuben.pokemontcgcollectorbackend.core.configuration.application.mapstruct.MapperConfiguration;
import com.beuben.pokemontcgcollectorbackend.synchronization.domain.card.Card;
import com.beuben.pokemontcgcollectorbackend.synchronization.infrastructure.out.persistence.entity.CardEntity;
import org.mapstruct.Mapper;

@Mapper(
    config = MapperConfiguration.class,
    implementationName = "CardPersistenceMapper")
public interface CardMapper {
  CardEntity toEntity(Card card);

  Card toCard(CardEntity cardEntity);
}
