package com.beuben.pokemontcgcollectorbackend.collection.fixture;

import com.beuben.pokemontcgcollectorbackend.collection.domain.Collector;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.dto.result.CollectorDTO;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.entity.CollectorEntity;

public class CollectorFixture {
  public static CollectorEntity aValidCollectorEntity() {
    return new CollectorEntity()
        .withId(1L)
        .withUsername("username")
        .withPassword("password");
  }

  public static Collector aValidCollector() {
    return new Collector()
        .withId(1L)
        .withUsername("username")
        .withPassword("password");
  }

  public static CollectorDTO aValidCollectorDTO() {
    return CollectorDTO.builder()
        .id(1L)
        .username("username")
        .build();
  }
}
