package com.beuben.pokemontcgcollectorbackend.synchronization.infrastructure.in.rest.mapper;

import com.beuben.pokemontcgcollectorbackend.catalog.domain.Card;
import com.beuben.pokemontcgcollectorbackend.core.configuration.application.mapstruct.MapperConfiguration;
import com.beuben.pokemontcgcollectorbackend.synchronization.infrastructure.in.rest.dto.result.ExistingCardDTO;
import org.mapstruct.Mapper;

@Mapper(
    config = MapperConfiguration.class,
    implementationName = "ExistingCardRestMapper",
    uses = ExistingSetMapper.class)
public interface ExistingCardMapper {
  ExistingCardDTO toDTO(Card card);
}
