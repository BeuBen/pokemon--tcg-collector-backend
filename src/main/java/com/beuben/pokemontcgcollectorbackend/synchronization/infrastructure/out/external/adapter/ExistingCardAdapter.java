package com.beuben.pokemontcgcollectorbackend.synchronization.infrastructure.out.external.adapter;

import com.beuben.pokemontcgcollectorbackend.catalog.domain.Card;
import com.beuben.pokemontcgcollectorbackend.synchronization.application.port.out.provider.ExistingCardProvider;
import com.beuben.pokemontcgcollectorbackend.synchronization.infrastructure.out.external.api.pokemontcg.PokemonTcgApi;
import com.beuben.pokemontcgcollectorbackend.synchronization.infrastructure.out.external.dto.result.PokemonTcgCardWrapperDTO;
import com.beuben.pokemontcgcollectorbackend.synchronization.infrastructure.out.external.mapper.CardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.IntStream;

import static com.beuben.pokemontcgcollectorbackend.synchronization.infrastructure.out.external.api.pokemontcg.PokemonTcgApiParam.INITIAL_PAGE;

@Component
@RequiredArgsConstructor
public class ExistingCardAdapter implements ExistingCardProvider {
  private final PokemonTcgApi pokemonTcgApi;
  private final CardMapper mapper;

  @Override
  public Flux<Card> findAll() {
    return fetchAllPages()
        .flatMapIterable(PokemonTcgCardWrapperDTO::data)
        .map(mapper::toDomain);
  }

  private Flux<PokemonTcgCardWrapperDTO> fetchAllPages() {
    return pokemonTcgApi.findAllCards(INITIAL_PAGE)
        .flatMapMany(this::getRemainingPages);
  }

  private Flux<PokemonTcgCardWrapperDTO> getRemainingPages(PokemonTcgCardWrapperDTO firstPage) {
    final var totalCount = firstPage.totalCount();
    final var pageSize = firstPage.pageSize();
    final var totalPages = (int) Math.ceil((double) totalCount / pageSize);

    var allRemainingPagesMonos = getParallelMonos(totalPages);

    return Flux.concat(
        Mono.just(firstPage),
        Flux.merge(allRemainingPagesMonos));
  }

  private List<Mono<PokemonTcgCardWrapperDTO>> getParallelMonos(int totalPages) {
    return IntStream.rangeClosed(INITIAL_PAGE + 1, totalPages)
        .mapToObj(pokemonTcgApi::findAllCards)
        .toList();
  }
}
