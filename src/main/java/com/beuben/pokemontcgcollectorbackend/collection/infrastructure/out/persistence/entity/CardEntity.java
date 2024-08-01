package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("card")
@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CardEntity {
  @Id private Long id;
  private Long setId;
  private String code;
  private String name;
  private String rarity;
  private String number;
  private String imageUrl;
}
