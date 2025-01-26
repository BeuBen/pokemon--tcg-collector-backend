package com.beuben.pokemontcgcollectorbackend.catalog.infrastructure.in.rest.controller;

import com.beuben.pokemontcgcollectorbackend.catalog.application.port.in.FetchAllCards;
import com.beuben.pokemontcgcollectorbackend.catalog.infrastructure.in.rest.dto.result.CardDTO;
import com.beuben.pokemontcgcollectorbackend.catalog.infrastructure.in.rest.mapper.CardMapper;
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

import static com.beuben.pokemontcgcollectorbackend.catalog.infrastructure.in.rest.Endpoints.CARDS;

@RestController
@RequiredArgsConstructor
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class CardController {
  private final FetchAllCards fetchAllCards;
  private final CardMapper mapper;

  @Operation(
      summary = "Fetch all cards",
      description = "Fetch all cards from database",
      tags = {"Card"})
  @ApiResponses(
      value = {
          @ApiResponse(
              responseCode = "200",
              description = "List of cards fetched",
              content = {@Content(array = @ArraySchema(
                  schema = @Schema(implementation = CardDTO.class)))})
      })
  @GetMapping(CARDS)
  public Mono<ResponseEntity<List<CardDTO>>> findAllCards() {
    return fetchAllCards.execute()
        .map(mapper::toDTO)
        .collectList()
        .map(ResponseEntity::ok);
  }
}
