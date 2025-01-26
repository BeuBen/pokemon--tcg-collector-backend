package com.beuben.pokemontcgcollectorbackend.catalog.infrastructure.out.persistence.mapper;

import com.beuben.pokemontcgcollectorbackend.catalog.domain.Card;
import com.beuben.pokemontcgcollectorbackend.catalog.infrastructure.out.persistence.entity.CardEntity;
import com.beuben.pokemontcgcollectorbackend.core.configuration.application.mapstruct.MapperConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
    config = MapperConfiguration.class,
    implementationName = "CardPersistenceMapper")
public interface CardMapper {

  @Mapping(source = "set.id", target = "setId")
  @Mapping(source = "image", target = "imageUrl")
  CardEntity toEntity(Card card);

  @Mapping(source = "setId", target = "set.id")
  @Mapping(source = "imageUrl", target = "image")
  Card toCard(CardEntity entity);
}
