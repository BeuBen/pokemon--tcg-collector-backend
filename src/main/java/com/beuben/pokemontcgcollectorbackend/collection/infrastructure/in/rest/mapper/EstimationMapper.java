package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.mapper;

import com.beuben.pokemontcgcollectorbackend.collection.domain.CollectionEstimation;
import com.beuben.pokemontcgcollectorbackend.collection.domain.CollectionEstimationDetail;
import com.beuben.pokemontcgcollectorbackend.collection.domain.Estimation;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.dto.command.UpdateItemEstimationCommand;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.dto.result.CollectionEstimationDTO;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.dto.result.CollectionEstimationDetailDTO;
import com.beuben.pokemontcgcollectorbackend.core.configuration.application.mapstruct.MapperConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
    config = MapperConfiguration.class,
    implementationName = "EstimationRestMapper")
public interface EstimationMapper {

  @Mapping(target = "priceInEuros", source = "estimationEuros")
  @Mapping(target = "sourceUrl", source = "estimationSourceUrl")
  Estimation toDomain(UpdateItemEstimationCommand command);

  CollectionEstimationDTO toDTO(CollectionEstimation estimation);

  CollectionEstimationDetailDTO toDTO(CollectionEstimationDetail estimationDetail);
}
