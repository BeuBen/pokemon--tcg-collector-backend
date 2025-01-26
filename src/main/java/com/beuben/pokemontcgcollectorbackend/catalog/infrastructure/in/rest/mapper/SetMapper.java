package com.beuben.pokemontcgcollectorbackend.catalog.infrastructure.in.rest.mapper;

import com.beuben.pokemontcgcollectorbackend.catalog.domain.CardSet;
import com.beuben.pokemontcgcollectorbackend.catalog.infrastructure.in.rest.dto.result.SetDTO;
import com.beuben.pokemontcgcollectorbackend.core.configuration.application.mapstruct.MapperConfiguration;
import org.mapstruct.Mapper;

@Mapper(
    config = MapperConfiguration.class,
    implementationName = "SetRestMapper")
public interface SetMapper {
  SetDTO toDTO(CardSet set);
}
