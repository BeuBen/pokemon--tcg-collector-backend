package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.out.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("collector")
@Data
@With
@AllArgsConstructor
@NoArgsConstructor
public class CollectorEntity {
  @Id
  Long id;
  String username;
  String password;
}
