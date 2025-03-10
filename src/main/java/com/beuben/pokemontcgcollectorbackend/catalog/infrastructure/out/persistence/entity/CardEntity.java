package com.beuben.pokemontcgcollectorbackend.catalog.infrastructure.out.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("card")
@Data
@With
@AllArgsConstructor
@NoArgsConstructor
public class CardEntity {
  @Id
  private Long id;
  private Long setId;
  private String code;
  private String name;
  private String rarity;
  private String number;
  private String imageUrl;
}
