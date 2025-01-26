package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.mapper;

import com.beuben.pokemontcgcollectorbackend.collection.domain.Item;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.entity.ItemEntity;
import com.beuben.pokemontcgcollectorbackend.core.configuration.application.mapstruct.MapperConfiguration;
import org.mapstruct.Mapper;

@Mapper(
    config = MapperConfiguration.class,
    implementationName = "ItemPersistenceMapper")
public interface ItemMapper {
  Item toDomain(ItemEntity entity);
}
