package com.beuben.pokemontcgcollectorbackend.synchronization.infrastructure.out.external.mapper;

import com.beuben.pokemontcgcollectorbackend.collection.domain.CardSet;
import com.beuben.pokemontcgcollectorbackend.core.configuration.application.mapstruct.MapperConfiguration;
import com.beuben.pokemontcgcollectorbackend.synchronization.infrastructure.out.external.dto.result.PokemonTcgSetDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Mapper(
    config = MapperConfiguration.class,
    implementationName = "SetApiMapper")
public interface SetMapper {

  @Mapping(source = "id", target = "code")
  @Mapping(target = "id", ignore = true)
  @Mapping(source = "total", target = "cardTotal")
  @Mapping(source = "releaseDate", target = "releaseDate", qualifiedByName = "parseDateToLocalDateTime")
  @Mapping(source = "images.symbol", target = "symbolImage")
  @Mapping(source = "images.logo", target = "logoImage")
  CardSet toDomain(PokemonTcgSetDTO dto);

  @Named("parseDateToLocalDateTime")
  default LocalDateTime parseDateToLocalDateTime(String date) {
    return LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy/MM/dd"))
        .atStartOfDay();
  }
}
