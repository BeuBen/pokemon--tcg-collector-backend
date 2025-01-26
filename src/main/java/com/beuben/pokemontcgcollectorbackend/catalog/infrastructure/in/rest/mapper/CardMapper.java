package com.beuben.pokemontcgcollectorbackend.catalog.infrastructure.in.rest.mapper;

import com.beuben.pokemontcgcollectorbackend.catalog.domain.Card;
import com.beuben.pokemontcgcollectorbackend.catalog.infrastructure.in.rest.dto.result.CardDTO;
import com.beuben.pokemontcgcollectorbackend.core.configuration.application.mapstruct.MapperConfiguration;
import org.mapstruct.Mapper;

@Mapper(
    config = MapperConfiguration.class,
    implementationName = "CardRestMapper",
    uses = SetMapper.class)
public interface CardMapper {
  CardDTO toDTO(Card card);
}
