package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.controller;

import com.beuben.pokemontcgcollectorbackend.collection.application.port.in.add.*;
import com.beuben.pokemontcgcollectorbackend.collection.application.port.in.fetch.*;
import com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.dto.command.*;
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
  private final FetchAllCollectorMasterSets fetchAllCollectorMasterSets;
  private final FetchAllCollectorSealed fetchAllCollectorSealed;
  private final AddGoodiesToCollection addGoodiesToCollection;
  private final AddGradedCardToCollection addGradedCardToCollection;
  private final AddLooseCardToCollection addLooseCardToCollection;
  private final AddMasterSetToCollection addMasterSetToCollection;
  private final AddSealedToCollection addSealedToCollection;
  private final CollectorMapper collectorMapper;
  private final GoodiesMapper goodiesMapper;
  private final GradedCardMapper gradedCardMapper;
  private final ItemMapper itemMapper;
  private final LooseCardMapper looseCardMapper;
  private final MasterSetMapper masterSetMapper;
  private final SealedMapper sealedMapper;

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
                  .fromPath(LOOSE_CARD)
                  .buildAndExpand(dto.id())
                  .toUri();

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
                  .fromPath(GRADED_CARD)
                  .buildAndExpand(dto.id())
                  .toUri();

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
                  .fromPath(GOODIES)
                  .buildAndExpand(dto.id())
                  .toUri();

          return ResponseEntity
              .created(location)
              .body(dto);
        });
  }

  @Operation(
      summary = "Fetch all collector's master sets",
      description = "Fetch all collector's master sets from its id",
      tags = {"Collection"})
  @ApiResponses(
      value = {
          @ApiResponse(
              responseCode = "200",
              description = "List of master sets fetched",
              content = {@Content(array = @ArraySchema(
                  schema = @Schema(implementation = MasterSetDTO.class)))}),
          @ApiResponse(
              responseCode = "404",
              description = "Collector not found",
              content = @Content(schema = @Schema(implementation = ErrorDTO.class)))
      })
  @GetMapping(COLLECTOR_MASTER_SETS)
  public Mono<ResponseEntity<List<MasterSetDTO>>> findAllCollectorMasterSets(@PathVariable final Long collectorId) {
    return fetchAllCollectorMasterSets.execute(collectorId)
        .map(masterSetMapper::toDTO)
        .collectList()
        .map(ResponseEntity::ok);
  }

  @Operation(
      summary = "Add master set to collection",
      description = "Add master set to collection",
      tags = {"Collection"})
  @ApiResponses(
      value = {
          @ApiResponse(
              responseCode = "201",
              description = "Master set added successfully",
              content = @Content(schema = @Schema(implementation = MasterSetDTO.class)))
      })
  @PostMapping(COLLECTOR_MASTER_SETS)
  public Mono<ResponseEntity<MasterSetDTO>> addMasterSetToCollection(
      @PathVariable final Long collectorId,
      @RequestBody @Valid final AddMasterSetCommand command) {
    final var masterSet = masterSetMapper.toDomain(command, collectorId);
    return addMasterSetToCollection.execute(masterSet)
        .map(masterSetMapper::toDTO)
        .map(dto -> {
          final URI location =
              UriComponentsBuilder
                  .fromPath(MASTER_SET)
                  .buildAndExpand(dto.id())
                  .toUri();

          return ResponseEntity
              .created(location)
              .body(dto);
        });
  }

  @Operation(
      summary = "Fetch all collector's sealed",
      description = "Fetch all collector's sealed from its id",
      tags = {"Collection"})
  @ApiResponses(
      value = {
          @ApiResponse(
              responseCode = "200",
              description = "List of sealed fetched",
              content = {@Content(array = @ArraySchema(
                  schema = @Schema(implementation = SealedDTO.class)))}),
          @ApiResponse(
              responseCode = "404",
              description = "Collector not found",
              content = @Content(schema = @Schema(implementation = ErrorDTO.class)))
      })
  @GetMapping(COLLECTOR_SEALED)
  public Mono<ResponseEntity<List<SealedDTO>>> findAllCollectorSealed(@PathVariable final Long collectorId) {
    return fetchAllCollectorSealed.execute(collectorId)
        .map(sealedMapper::toDTO)
        .collectList()
        .map(ResponseEntity::ok);
  }

  @Operation(
      summary = "Add sealed to collection",
      description = "Add sealed to collection",
      tags = {"Collection"})
  @ApiResponses(
      value = {
          @ApiResponse(
              responseCode = "201",
              description = "Sealed added successfully",
              content = @Content(schema = @Schema(implementation = SealedDTO.class)))
      })
  @PostMapping(COLLECTOR_SEALED)
  public Mono<ResponseEntity<SealedDTO>> addSealedToCollection(
      @PathVariable final Long collectorId,
      @RequestBody @Valid final AddSealedCommand command) {
    final var sealed = sealedMapper.toDomain(command, collectorId);
    return addSealedToCollection.execute(sealed)
        .map(sealedMapper::toDTO)
        .map(dto -> {
          final URI location =
              UriComponentsBuilder
                  .fromPath(SEALED)
                  .buildAndExpand(dto.id())
                  .toUri();

          return ResponseEntity
              .created(location)
              .body(dto);
        });
  }
}
