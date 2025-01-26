package com.beuben.pokemontcgcollectorbackend.synchronization.infrastructure.in.rest.mapper;

import com.beuben.pokemontcgcollectorbackend.catalog.domain.CardSet;
import com.beuben.pokemontcgcollectorbackend.core.configuration.application.mapstruct.MapperConfiguration;
import com.beuben.pokemontcgcollectorbackend.synchronization.infrastructure.in.rest.dto.result.ExistingSetDTO;
import org.mapstruct.Mapper;

@Mapper(
    config = MapperConfiguration.class,
    implementationName = "ExistingSetRestMapper")
public interface ExistingSetMapper {
  ExistingSetDTO toDTO(CardSet set);
}
