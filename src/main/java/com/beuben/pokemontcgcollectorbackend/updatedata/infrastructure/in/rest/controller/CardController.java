package com.beuben.pokemontcgcollectorbackend.updatedata.infrastructure.in.rest.controller;

import com.beuben.pokemontcgcollectorbackend.updatedata.application.port.in.FetchCards;
import com.beuben.pokemontcgcollectorbackend.updatedata.domain.card.Card;
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
@RequestMapping(value = "/update-data", produces = MediaType.APPLICATION_JSON_VALUE)
public class CardController {
  private final FetchCards fetchCards;

  @Operation(tags = "Card",
      summary = "Fetch all cards",
      description = "Fetch all cards from pokemontcg.io API")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200",
          description = "List of card fetched",
          content = {
              @Content(array = @ArraySchema(schema = @Schema(implementation = Card.class)))
          })
  })
  @GetMapping("/cards")
  public Mono<ResponseEntity<List<Card>>> findAll() {
    return fetchCards.execute()
        .collectList()
        .map(ResponseEntity::ok);
  }
}
