package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.mapper;

import com.beuben.pokemontcgcollectorbackend.collection.domain.CardSet;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.entity.SetEntity;
import com.beuben.pokemontcgcollectorbackend.core.configuration.application.mapstruct.MapperConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
    config = MapperConfiguration.class,
    implementationName = "SetPersistenceMapper")
public interface SetMapper {

  @Mapping(source = "symbolImage", target = "symbolUrl")
  @Mapping(source = "logoImage", target = "logoUrl")
  SetEntity toEntity(CardSet cardSet);

  @Mapping(source = "symbolUrl", target = "symbolImage")
  @Mapping(source = "logoUrl", target = "logoImage")
  CardSet toCardSet(SetEntity entity);
}
