package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.controller;

import com.beuben.pokemontcgcollectorbackend.collection.application.port.in.*;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.dto.command.AddGoodiesCommand;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.dto.command.AddGradedCardCommand;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.dto.command.AddLooseCardCommand;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.dto.result.*;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.mapper.*;
import com.beuben.pokemontcgcollectorbackend.core.exception.dto.ErrorDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.List;

import static com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.Endpoints.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = COLLECTION, produces = MediaType.APPLICATION_JSON_VALUE)
public class CollectionController {
  private final FetchCollector fetchCollector;
  private final FetchAllCollectorGoodies fetchAllCollectorGoodies;
  private final FetchAllCollectorGradedCards fetchAllCollectorGradedCards;
  private final FetchAllCollectorItems fetchAllCollectorItems;
  private final FetchAllCollectorLooseCards fetchAllCollectorLooseCards;
  private final AddGoodiesToCollection addGoodiesToCollection;
  private final AddGradedCardToCollection addGradedCardToCollection;
  private final AddLooseCardToCollection addLooseCardToCollection;
  private final CollectorMapper collectorMapper;
  private final GoodiesMapper goodiesMapper;
  private final GradedCardMapper gradedCardMapper;
  private final ItemMapper itemMapper;
  private final LooseCardMapper looseCardMapper;

  @Operation(
      summary = "Get collector by username",
      description = "Get collector by username",
      tags = {"Collection"})
  @ApiResponses(
      value = {
          @ApiResponse(
              responseCode = "200",
              description = "Collector found successfully",
              content = @Content(schema = @Schema(implementation = CollectorDTO.class))),
          @ApiResponse(
              responseCode = "404",
              description = "Collector not found",
              content = @Content(schema = @Schema(implementation = ErrorDTO.class)))
      })
  @GetMapping(COLLECTORS)
  public Mono<ResponseEntity<CollectorDTO>> findCollectorByUsername(@RequestParam final String username) {
    return fetchCollector.execute(username)
        .map(collectorMapper::toDto)
        .map(ResponseEntity::ok);
  }

  @Operation(
      summary = "Fetch all collector's items",
      description = "Fetch all collector's items from its id",
      tags = {"Collection"})
  @ApiResponses(
      value = {
          @ApiResponse(
              responseCode = "200",
              description = "List of items fetched",
              content = {@Content(array = @ArraySchema(
                  schema = @Schema(implementation = ItemDTO.class)))}),
          @ApiResponse(
              responseCode = "404",
              description = "Collector not found",
              content = @Content(schema = @Schema(implementation = ErrorDTO.class)))
      })
  @GetMapping(COLLECTOR_ITEMS)
  public Mono<ResponseEntity<List<ItemDTO>>> findAllCollectorItems(@PathVariable final Long collectorId) {
    return fetchAllCollectorItems.execute(collectorId)
        .map(itemMapper::toDTO)
        .collectList()
        .map(ResponseEntity::ok);
  }

  @Operation(
      summary = "Fetch all collector's loose cards",
      description = "Fetch all collector's loose cards from its id",
      tags = {"Collection"})
  @ApiResponses(
      value = {
          @ApiResponse(
              responseCode = "200",
              description = "List of loose cards fetched",
              content = {@Content(array = @ArraySchema(
                  schema = @Schema(implementation = LooseCardDTO.class)))}),
          @ApiResponse(
              responseCode = "404",
              description = "Collector not found",
              content = @Content(schema = @Schema(implementation = ErrorDTO.class)))
      })
  @GetMapping(COLLECTOR_LOOSE_CARDS)
  public Mono<ResponseEntity<List<LooseCardDTO>>> findAllCollectorLooseCards(@PathVariable final Long collectorId) {
    return fetchAllCollectorLooseCards.execute(collectorId)
        .map(looseCardMapper::toDTO)
        .collectList()
        .map(ResponseEntity::ok);
  }

  @Operation(
      summary = "Add loose card to collection",
      description = "Add loose card to collection",
      tags = {"Collection"})
  @ApiResponses(
      value = {
          @ApiResponse(
              responseCode = "201",
              description = "Loose card added successfully",
              content = @Content(schema = @Schema(implementation = LooseCardDTO.class)))
      })
  @PostMapping(COLLECTOR_LOOSE_CARDS)
  public Mono<ResponseEntity<LooseCardDTO>> addLooseCardToCollection(
      @PathVariable final Long collectorId,
      @RequestBody @Valid final AddLooseCardCommand command) {
    final var looseCard = looseCardMapper.toDomain(command, collectorId);
    return addLooseCardToCollection.execute(looseCard)
        .map(looseCardMapper::toDTO)
        .map(dto -> {
          final URI location =
              UriComponentsBuilder
                  .fromUriString(LOOSE_CARD)
                  .build(dto.id());

          return ResponseEntity
              .created(location)
              .body(dto);
        });
  }

  @Operation(
      summary = "Fetch all collector's graded cards",
      description = "Fetch all collector's graded cards from its id",
      tags = {"Collection"})
  @ApiResponses(
      value = {
          @ApiResponse(
              responseCode = "200",
              description = "List of graded cards fetched",
              content = {@Content(array = @ArraySchema(
                  schema = @Schema(implementation = GradedCardDTO.class)))}),
          @ApiResponse(
              responseCode = "404",
              description = "Collector not found",
              content = @Content(schema = @Schema(implementation = ErrorDTO.class)))
      })
  @GetMapping(COLLECTOR_GRADED_CARDS)
  public Mono<ResponseEntity<List<GradedCardDTO>>> findAllCollectorGradedCards(@PathVariable final Long collectorId) {
    return fetchAllCollectorGradedCards.execute(collectorId)
        .map(gradedCardMapper::toDTO)
        .collectList()
        .map(ResponseEntity::ok);
  }

  @Operation(
      summary = "Add graded card to collection",
      description = "Add graded card to collection",
      tags = {"Collection"})
  @ApiResponses(
      value = {
          @ApiResponse(
              responseCode = "201",
              description = "Graded card added successfully",
              content = @Content(schema = @Schema(implementation = GradedCardDTO.class)))
      })
  @PostMapping(COLLECTOR_GRADED_CARDS)
  public Mono<ResponseEntity<GradedCardDTO>> addGradedCardToCollection(
      @PathVariable final Long collectorId,
      @RequestBody @Valid final AddGradedCardCommand command) {
    final var gradedCard = gradedCardMapper.toDomain(command, collectorId);
    return addGradedCardToCollection.execute(gradedCard)
        .map(gradedCardMapper::toDTO)
        .map(dto -> {
          final URI location =
              UriComponentsBuilder
                  .fromUriString(GRADED_CARD)
                  .build(dto.id());

          return ResponseEntity
              .created(location)
              .body(dto);
        });
  }

  @Operation(
      summary = "Fetch all collector's goodies",
      description = "Fetch all collector's goodies from its id",
      tags = {"Collection"})
  @ApiResponses(
      value = {
          @ApiResponse(
              responseCode = "200",
              description = "List of goodies fetched",
              content = {@Content(array = @ArraySchema(
                  schema = @Schema(implementation = GoodiesDTO.class)))}),
          @ApiResponse(
              responseCode = "404",
              description = "Collector not found",
              content = @Content(schema = @Schema(implementation = ErrorDTO.class)))
      })
  @GetMapping(COLLECTOR_GOODIES)
  public Mono<ResponseEntity<List<GoodiesDTO>>> findAllCollectorGoodies(@PathVariable final Long collectorId) {
    return fetchAllCollectorGoodies.execute(collectorId)
        .map(goodiesMapper::toDTO)
        .collectList()
        .map(ResponseEntity::ok);
  }

  @Operation(
      summary = "Add goodies to collection",
      description = "Add goodies to collection",
      tags = {"Collection"})
  @ApiResponses(
      value = {
          @ApiResponse(
              responseCode = "201",
              description = "Goodies added successfully",
              content = @Content(schema = @Schema(implementation = GoodiesDTO.class)))
      })
  @PostMapping(COLLECTOR_GOODIES)
  public Mono<ResponseEntity<GoodiesDTO>> addGoodiesToCollection(
      @PathVariable final Long collectorId,
      @RequestBody @Valid final AddGoodiesCommand command) {
    final var goodies = goodiesMapper.toDomain(command, collectorId);
    return addGoodiesToCollection.execute(goodies)
        .map(goodiesMapper::toDTO)
        .map(dto -> {
          final URI location =
              UriComponentsBuilder
                  .fromUriString(GOODIES)
                  .build(dto.id());

          return ResponseEntity
              .created(location)
              .body(dto);
        });
  }
}
