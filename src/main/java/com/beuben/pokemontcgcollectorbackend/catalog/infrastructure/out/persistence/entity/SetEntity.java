package com.beuben.pokemontcgcollectorbackend.catalog.infrastructure.out.persistence.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("set")
@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class SetEntity {
  @Id
  private Long id;
  private String code;
  private String name;
  private String series;
  private Integer cardTotal;
  private LocalDateTime releaseDate;
  private String symbolUrl;
  private String logoUrl;
}
