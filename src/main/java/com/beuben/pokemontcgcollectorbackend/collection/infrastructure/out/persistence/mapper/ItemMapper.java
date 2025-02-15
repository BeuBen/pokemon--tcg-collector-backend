package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.mapper;

import com.beuben.pokemontcgcollectorbackend.collection.domain.*;
import com.beuben.pokemontcgcollectorbackend.core.configuration.application.mapstruct.MapperConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
    config = MapperConfiguration.class,
    implementationName = "ItemPersistenceMapper")
public interface ItemMapper {

  @Mapping(target = "itemType", constant = "GRADED_CARD")
  Item toItem(GradedCard gradedCard);

  @Mapping(target = "itemType", constant = "GOODIES")
  Item toItem(Goodies goodies);

  @Mapping(target = "itemType", constant = "LOOSE_CARD")
  Item toItem(LooseCard looseCard);

  @Mapping(target = "itemType", constant = "MASTER_SET")
  Item toItem(MasterSet masterSet);

  @Mapping(target = "itemType", constant = "SEALED")
  Item toItem(Sealed sealed);
}
