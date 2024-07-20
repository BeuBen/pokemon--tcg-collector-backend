package com.beuben.pokemontcgcollectorbackend.synchronization.infrastructure.out.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("card")
@Getter
@Setter
@AllArgsConstructor
public class CardEntity {
  @Id private Long id;
  private String code;
  private String name;
}
