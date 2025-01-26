package com.beuben.pokemontcgcollectorbackend.synchronization.infrastructure.in.rest.controller;

import com.beuben.pokemontcgcollectorbackend.synchronization.application.port.in.FetchAllExistingCards;
import com.beuben.pokemontcgcollectorbackend.synchronization.application.port.in.FetchAllExistingSets;
import com.beuben.pokemontcgcollectorbackend.synchronization.infrastructure.in.rest.dto.result.ExistingCardDTO;
import com.beuben.pokemontcgcollectorbackend.synchronization.infrastructure.in.rest.dto.result.ExistingSetDTO;
import com.beuben.pokemontcgcollectorbackend.synchronization.infrastructure.in.rest.mapper.ExistingCardMapper;
import com.beuben.pokemontcgcollectorbackend.synchronization.infrastructure.in.rest.mapper.ExistingSetMapper;
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

import static com.beuben.pokemontcgcollectorbackend.synchronization.infrastructure.in.rest.Endpoints.CARDS;
import static com.beuben.pokemontcgcollectorbackend.synchronization.infrastructure.in.rest.Endpoints.SETS;

@RestController
@RequiredArgsConstructor
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class DataController {
  private final FetchAllExistingCards fetchAllExistingCards;
  private final FetchAllExistingSets fetchAllExistingSets;
  private final ExistingCardMapper cardMapper;
  private final ExistingSetMapper setMapper;

  @Operation(
      summary = "Fetch all existing cards",
      description = "Fetch all existing cards from pokemontcg.io API",
      tags = {"Data"})
  @ApiResponses(
      value = {
          @ApiResponse(
              responseCode = "200",
              description = "List of cards fetched",
              content = {@Content(array = @ArraySchema(
                  schema = @Schema(implementation = ExistingCardDTO.class)))})
      })
  @GetMapping(CARDS)
  public Mono<ResponseEntity<List<ExistingCardDTO>>> findAllExistingCards() {
    return fetchAllExistingCards.execute()
        .map(cardMapper::toDTO)
        .collectList()
        .map(ResponseEntity::ok);
  }

  @Operation(
      summary = "Fetch all existing sets",
      description = "Fetch all existing sets from pokemontcg.io API",
      tags = {"Data"})
  @ApiResponses(
      value = {
          @ApiResponse(
              responseCode = "200",
              description = "List of sets fetched",
              content = {@Content(array = @ArraySchema(
                  schema = @Schema(implementation = ExistingSetDTO.class)))})
      })
  @GetMapping(SETS)
  public Mono<ResponseEntity<List<ExistingSetDTO>>> findAllExistingSets() {
    return fetchAllExistingSets.execute()
        .map(setMapper::toDTO)
        .collectList()
        .map(ResponseEntity::ok);
  }
}
