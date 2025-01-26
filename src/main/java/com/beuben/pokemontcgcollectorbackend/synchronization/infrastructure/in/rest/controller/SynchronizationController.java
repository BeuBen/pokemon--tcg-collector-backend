package com.beuben.pokemontcgcollectorbackend.synchronization.infrastructure.in.rest.controller;

import com.beuben.pokemontcgcollectorbackend.synchronization.application.port.in.RefreshCards;
import com.beuben.pokemontcgcollectorbackend.synchronization.application.port.in.RefreshSets;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import static com.beuben.pokemontcgcollectorbackend.synchronization.infrastructure.in.rest.Endpoints.CARDS;
import static com.beuben.pokemontcgcollectorbackend.synchronization.infrastructure.in.rest.Endpoints.SETS;

@RestController
@RequiredArgsConstructor
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class SynchronizationController {
  private final RefreshCards refreshCards;
  private final RefreshSets refreshSets;

  @Operation(
      summary = "Synchronize card database",
      description = "Synchronize card database with pokemontcg.io API data",
      tags = {"Refresh"})
  @ApiResponses(
      value = {
          @ApiResponse(
              responseCode = "200",
              description = "Card table synchronized")
      })
  @PostMapping(CARDS)
  public Mono<ResponseEntity<Void>> refreshCards() {
    return refreshCards.execute()
        .then(Mono.just(ResponseEntity.ok().build()));
  }

  @Operation(
      summary = "Synchronize set database",
      description = "Synchronize set database with pokemontcg.io API data",
      tags = {"Refresh"})
  @ApiResponses(
      value = {
          @ApiResponse(
              responseCode = "200",
              description = "Set table synchronized")
      })
  @PostMapping(SETS)
  public Mono<ResponseEntity<Void>> refreshSets() {
    return refreshSets.execute()
        .then(Mono.just(ResponseEntity.ok().build()));
  }
}
