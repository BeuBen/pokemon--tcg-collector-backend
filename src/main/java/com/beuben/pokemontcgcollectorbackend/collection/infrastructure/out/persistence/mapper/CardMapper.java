package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.mapper;

import com.beuben.pokemontcgcollectorbackend.collection.domain.Card;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.entity.CardEntity;
import com.beuben.pokemontcgcollectorbackend.core.configuration.application.mapstruct.MapperConfiguration;
import org.mapstruct.Mapper;

@Mapper(
    config = MapperConfiguration.class,
    implementationName = "CardPersistenceMapper")
public interface CardMapper {
  CardEntity toEntity(Card card);

  Card toCard(CardEntity entity);
}
