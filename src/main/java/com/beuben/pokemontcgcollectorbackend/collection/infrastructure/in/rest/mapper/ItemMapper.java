package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.mapper;

import com.beuben.pokemontcgcollectorbackend.collection.domain.Item;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.dto.result.ItemDTO;
import com.beuben.pokemontcgcollectorbackend.core.configuration.application.mapstruct.MapperConfiguration;
import org.mapstruct.Mapper;

@Mapper(
    config = MapperConfiguration.class,
    implementationName = "ItemRestMapper")
public interface ItemMapper {
  ItemDTO toDTO(Item item);
}
