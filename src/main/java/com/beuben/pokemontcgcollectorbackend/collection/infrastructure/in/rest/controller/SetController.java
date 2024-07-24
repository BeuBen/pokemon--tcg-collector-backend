package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.controller;

import com.beuben.pokemontcgcollectorbackend.collection.application.port.in.FetchAllSets;
import com.beuben.pokemontcgcollectorbackend.collection.domain.CardSet;
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
@RequestMapping(value = "/collection/sets", produces = MediaType.APPLICATION_JSON_VALUE)
public class SetController {
  private final FetchAllSets fetchAllSets;

  @Operation(
      summary = "Fetch all sets",
      description = "Fetch all sets from database",
      tags = {"Set"})
  @ApiResponses(
      value = {
          @ApiResponse(
              responseCode = "200",
              description = "List of sets fetched",
              content = {@Content(array = @ArraySchema(
                  schema = @Schema(implementation = CardSet.class)))})
      })
  @GetMapping
  public Mono<ResponseEntity<List<CardSet>>> findAllCards() {
    return fetchAllSets.execute()
        .collectList()
        .map(ResponseEntity::ok);
  }
}
