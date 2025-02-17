package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.mapper;

import com.beuben.pokemontcgcollectorbackend.collection.domain.GradedCard;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.dto.command.AddGradedCardCommand;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.dto.result.GradedCardDTO;
import com.beuben.pokemontcgcollectorbackend.core.configuration.application.mapstruct.MapperConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
    config = MapperConfiguration.class,
    implementationName = "GradedCardRestMapper")
public interface GradedCardMapper {

  @Mapping(target = "estimation.priceInEuros", source = "command.estimationEuros")
  @Mapping(target = "estimation.sourceUrl", source = "command.estimationSourceUrl")
  @Mapping(target = "grading.society", source = "command.gradingSociety")
  @Mapping(target = "grading.grade", source = "command.grade")
  @Mapping(target = "grading.reference", source = "command.gradingReference")
  GradedCard toDomain(AddGradedCardCommand command, Long collectorId);

  GradedCardDTO toDTO(GradedCard gradedCard);
}
