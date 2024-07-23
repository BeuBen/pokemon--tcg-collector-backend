package com.beuben.pokemontcgcollectorbackend.synchronization.infrastructure.in.rest.controller;

import com.beuben.pokemontcgcollectorbackend.synchronization.application.port.in.FetchAllCards;
import com.beuben.pokemontcgcollectorbackend.synchronization.domain.card.Card;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/synchro/data", produces = MediaType.APPLICATION_JSON_VALUE)
public class DataController {
  @Qualifier("fetchAllExternalCardsUsecase") private final FetchAllCards fetchAllExistingCards;
  @Qualifier("fetchAllDatabaseCardsUsecase") private final FetchAllCards fetchAllPersistedCards;

  @Operation(
      summary = "Fetch all existing cards",
      description = "Fetch all cards from pokemontcg.io API",
      tags = {"Card"})
  @ApiResponses(
      value = {
          @ApiResponse(
              responseCode = "200",
              description = "List of cards fetched",
              content = {@Content(array = @ArraySchema(
                  schema = @Schema(implementation = Card.class)))})
      })
  @GetMapping("/cards/external")
  public Mono<ResponseEntity<List<Card>>> findAllExistingCards() {
    return fetchAllExistingCards.execute()
        .collectList()
        .map(ResponseEntity::ok);
  }

  @Operation(
      summary = "Fetch all persisted cards",
      description = "Fetch all cards from database",
      tags = {"Card"})
  @ApiResponses(
      value = {
          @ApiResponse(
              responseCode = "200",
              description = "List of cards fetched",
              content = {@Content(array = @ArraySchema(
                  schema = @Schema(implementation = Card.class)))})
      })
  @GetMapping("/cards/internal")
  public Mono<ResponseEntity<List<Card>>> findAllPersistedCards() {
    //TODO this will be moved to the main feature collection package later
    return fetchAllPersistedCards.execute()
        .collectList()
        .map(ResponseEntity::ok);
  }
}
