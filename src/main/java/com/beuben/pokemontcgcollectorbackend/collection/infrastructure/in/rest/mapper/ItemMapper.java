package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.mapper;

import com.beuben.pokemontcgcollectorbackend.collection.domain.Item;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.dto.result.ItemDTO;
import com.beuben.pokemontcgcollectorbackend.core.configuration.application.mapstruct.MapperConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
    config = MapperConfiguration.class,
    implementationName = "ItemRestMapper")
public interface ItemMapper {

  @Mapping(target = "estimationEuros", source = "estimation.priceInEuros")
  @Mapping(target = "estimationDate", source = "estimation.date")
  @Mapping(target = "estimationSourceUrl", source = "estimation.sourceUrl")
  ItemDTO toDTO(Item item);
}
