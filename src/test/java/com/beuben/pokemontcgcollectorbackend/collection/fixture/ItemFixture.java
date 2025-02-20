package com.beuben.pokemontcgcollectorbackend.collection.fixture;

import com.beuben.pokemontcgcollectorbackend.collection.domain.Item;
import com.beuben.pokemontcgcollectorbackend.collection.domain.ItemType;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.dto.result.ItemDTO;

import java.time.LocalDateTime;

import static com.beuben.pokemontcgcollectorbackend.collection.fixture.EstimationFixture.aValidEstimation;

public class ItemFixture {
  public static Item aValidItem() {
    return new Item()
        .withId(1L)
        .withLabel("test")
        .withItemType(ItemType.GRADED_CARD)
        .withEstimation(aValidEstimation())
        .withPicturesUrl("pictures_url.com")
        .withCreationDate(LocalDateTime.MIN);
  }

  public static ItemDTO aValidItemDTO() {
    return ItemDTO.builder()
        .id(1L)
        .label("test")
        .itemType(ItemType.GRADED_CARD)
        .estimationEuros(aValidEstimation().getPriceInEuros())
        .estimationDate(aValidEstimation().getDate())
        .estimationSourceUrl(aValidEstimation().getSourceUrl())
        .picturesUrl("pictures_url.com")
        .creationDate(LocalDateTime.MIN)
        .build();
  }
}
