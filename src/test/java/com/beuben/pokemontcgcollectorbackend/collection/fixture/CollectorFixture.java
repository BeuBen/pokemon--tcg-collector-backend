package com.beuben.pokemontcgcollectorbackend.collection.fixture;

import com.beuben.pokemontcgcollectorbackend.collection.domain.Collector;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.entity.CollectorEntity;

public class CollectorFixture {
  public static Collector aValidCollector() {
    return new Collector()
        .withId(1L)
        .withUsername("username")
        .withPassword("password");
  }

  public static CollectorEntity aValidCollectorEntity() {
    return new CollectorEntity()
        .withId(1L)
        .withUsername("username")
        .withPassword("password");
  }
}
