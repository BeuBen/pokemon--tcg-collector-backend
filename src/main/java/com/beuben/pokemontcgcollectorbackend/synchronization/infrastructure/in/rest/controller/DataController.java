package com.beuben.pokemontcgcollectorbackend.synchronization.infrastructure.in.rest.controller;

import com.beuben.pokemontcgcollectorbackend.catalog.domain.Card;
import com.beuben.pokemontcgcollectorbackend.catalog.domain.CardSet;
import com.beuben.pokemontcgcollectorbackend.synchronization.application.port.in.FetchAllExistingCards;
import com.beuben.pokemontcgcollectorbackend.synchronization.application.port.in.FetchAllExistingSets;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
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
  private final FetchAllExistingCards fetchAllExistingCards;
  private final FetchAllExistingSets fetchAllExistingSets;

  @Operation(
      summary = "Fetch all existing cards",
      description = "Fetch all existing cards from pokemontcg.io API",
      tags = {"Card"})
  @ApiResponses(
      value = {
          @ApiResponse(
              responseCode = "200",
              description = "List of cards fetched",
              content = {@Content(array = @ArraySchema(
                  schema = @Schema(implementation = Card.class)))})
      })
  @GetMapping("/cards")
  public Mono<ResponseEntity<List<Card>>> findAllExistingCards() {
    return fetchAllExistingCards.execute()
        .collectList()
        .map(ResponseEntity::ok);
  }

  @Operation(
      summary = "Fetch all existing sets",
      description = "Fetch all existing sets from pokemontcg.io API",
      tags = {"Set"})
  @ApiResponses(
      value = {
          @ApiResponse(
              responseCode = "200",
              description = "List of sets fetched",
              content = {@Content(array = @ArraySchema(
                  schema = @Schema(implementation = CardSet.class)))})
      })
  @GetMapping("/sets")
  public Mono<ResponseEntity<List<CardSet>>> findAllExistingSets() {
    return fetchAllExistingSets.execute()
        .collectList()
        .map(ResponseEntity::ok);
  }
}
