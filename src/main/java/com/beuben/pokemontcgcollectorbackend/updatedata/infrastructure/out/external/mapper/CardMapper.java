package com.beuben.pokemontcgcollectorbackend.updatedata.infrastructure.out.external.mapper;

import com.beuben.pokemontcgcollectorbackend.core.configuration.application.mapstruct.MapperConfiguration;
import com.beuben.pokemontcgcollectorbackend.updatedata.domain.card.Card;
import com.beuben.pokemontcgcollectorbackend.updatedata.infrastructure.out.external.dto.PokemonTcgCardDTO;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfiguration.class, implementationName = "CardApiMapper")
public interface CardMapper {
  Card toDomain(PokemonTcgCardDTO dto);
}
