package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.mapper;

import com.beuben.pokemontcgcollectorbackend.collection.domain.CardSet;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.entity.SetEntity;
import com.beuben.pokemontcgcollectorbackend.core.configuration.application.mapstruct.MapperConfiguration;
import org.mapstruct.Mapper;

@Mapper(
    config = MapperConfiguration.class,
    implementationName = "SetPersistenceMapper")
public interface SetMapper {
  CardSet toCardSet(SetEntity entity);
}
