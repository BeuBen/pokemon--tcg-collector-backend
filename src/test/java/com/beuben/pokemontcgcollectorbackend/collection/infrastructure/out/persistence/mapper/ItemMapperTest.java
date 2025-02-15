package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.mapper;

import com.beuben.pokemontcgcollectorbackend.collection.domain.ItemType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.beuben.pokemontcgcollectorbackend.collection.fixture.GoodiesFixture.aValidGoodies;
import static com.beuben.pokemontcgcollectorbackend.collection.fixture.GradedCardFixture.aValidGradedCard;
import static com.beuben.pokemontcgcollectorbackend.collection.fixture.ItemFixture.aValidItem;
import static com.beuben.pokemontcgcollectorbackend.collection.fixture.LooseCardFixture.aValidLooseCard;
import static com.beuben.pokemontcgcollectorbackend.collection.fixture.MasterSetFixture.aValidMasterSet;
import static com.beuben.pokemontcgcollectorbackend.collection.fixture.SealedFixture.aValidSealed;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ItemMapperTest {

  @Autowired
  private ItemMapper mapper;

  @Test
  void graded_card_mapping_should_return_the_right_item() {
    // ARRANGE
    final var gradedCard = aValidGradedCard();
    final var expected = aValidItem().withItemType(ItemType.GRADED_CARD);

    // ACT
    final var mapped = mapper.toItem(gradedCard);

    // ASSERT
    assertThat(mapped).isEqualTo(expected);
  }

  @Test
  void goodies_mapping_should_return_the_right_item() {
    // ARRANGE
    final var goodies = aValidGoodies();
    final var expected = aValidItem().withItemType(ItemType.GOODIES);

    // ACT
    final var mapped = mapper.toItem(goodies);

    // ASSERT
    assertThat(mapped).isEqualTo(expected);
  }

  @Test
  void loose_card_mapping_should_return_the_right_item() {
    // ARRANGE
    final var looseCard = aValidLooseCard();
    final var expected = aValidItem().withItemType(ItemType.LOOSE_CARD);

    // ACT
    final var mapped = mapper.toItem(looseCard);

    // ASSERT
    assertThat(mapped).isEqualTo(expected);
  }

  @Test
  void master_set_mapping_should_return_the_right_item() {
    // ARRANGE
    final var masterSet = aValidMasterSet();
    final var expected = aValidItem().withItemType(ItemType.MASTER_SET);

    // ACT
    final var mapped = mapper.toItem(masterSet);

    // ASSERT
    assertThat(mapped).isEqualTo(expected);
  }

  @Test
  void sealed_mapping_should_return_the_right_item() {
    // ARRANGE
    final var sealed = aValidSealed();
    final var expected = aValidItem().withItemType(ItemType.SEALED);

    // ACT
    final var mapped = mapper.toItem(sealed);

    // ASSERT
    assertThat(mapped).isEqualTo(expected);
  }
}