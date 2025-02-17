package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.mapper;

import com.beuben.pokemontcgcollectorbackend.collection.domain.GradedCard;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.entity.GradedCardEntity;
import com.beuben.pokemontcgcollectorbackend.core.configuration.application.mapstruct.MapperConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
    config = MapperConfiguration.class,
    implementationName = "GradedCardPersistenceMapper")
public interface GradedCardMapper {

  @Mapping(target = "estimation.priceInEuros", source = "estimationEuros")
  @Mapping(target = "estimation.date", source = "estimationDate")
  @Mapping(target = "estimation.sourceUrl", source = "estimationSourceUrl")
  @Mapping(target = "grading.society", source = "gradingSociety")
  @Mapping(target = "grading.grade", source = "grade")
  @Mapping(target = "grading.reference", source = "gradingReference")
  GradedCard toDomain(GradedCardEntity entity);

  @Mapping(target = "estimationEuros", source = "estimation.priceInEuros")
  @Mapping(target = "estimationDate", source = "estimation.date")
  @Mapping(target = "estimationSourceUrl", source = "estimation.sourceUrl")
  @Mapping(target = "gradingSociety", source = "grading.society")
  @Mapping(target = "grade", source = "grading.grade")
  @Mapping(target = "gradingReference", source = "grading.reference")
  GradedCardEntity toEntity(GradedCard domain);
}
