package com.beuben.pokemontcgcollectorbackend.collection.fixture;

import com.beuben.pokemontcgcollectorbackend.collection.domain.Condition;
import com.beuben.pokemontcgcollectorbackend.collection.domain.Item;
import com.beuben.pokemontcgcollectorbackend.collection.domain.ItemType;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.dto.result.ItemDTO;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.entity.ItemEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ItemFixture {
  public static ItemEntity aValidItemEntity() {
    return new ItemEntity()
        .withId(1L)
        .withCollectorId(1L)
        .withLabel("test")
        .withItemType(ItemType.GRADED_CARD)
        .withCondition(Condition.MINT)
        .withEstimationEuros(BigDecimal.valueOf(200))
        .withEstimationDate(LocalDateTime.MIN)
        .withEstimationSourceUrl("estimation_url.com")
        .withPicturesUrl("pictures_url.com")
        .withComment("This is a comment")
        .withCreationDate(LocalDateTime.MIN);
  }

  public static Item aValidItem() {
    return new Item()
        .withId(1L)
        .withCollectorId(1L)
        .withLabel("test")
        .withItemType(ItemType.GRADED_CARD)
        .withCondition(Condition.MINT)
        .withEstimationEuros(BigDecimal.valueOf(200))
        .withEstimationDate(LocalDateTime.MIN)
        .withEstimationSourceUrl("estimation_url.com")
        .withPicturesUrl("pictures_url.com")
        .withComment("This is a comment")
        .withCreationDate(LocalDateTime.MIN);
  }

  public static ItemDTO aValidItemDTO() {
    return ItemDTO.builder()
        .id(1L)
        .collectorId(1L)
        .label("test")
        .itemType(ItemType.GRADED_CARD)
        .condition(Condition.MINT)
        .estimationEuros(BigDecimal.valueOf(200))
        .estimationDate(LocalDateTime.MIN)
        .estimationSourceUrl("estimation_url.com")
        .picturesUrl("pictures_url.com")
        .comment("This is a comment")
        .creationDate(LocalDateTime.MIN)
        .build();
  }
}
