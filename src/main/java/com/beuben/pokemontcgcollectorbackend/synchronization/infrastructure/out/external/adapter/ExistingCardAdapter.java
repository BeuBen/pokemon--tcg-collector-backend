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

import static com.beuben.pokemontcgcollectorbackend.synchronization.infrastructure.out.external.api.pokemontcg.PokemonTcgApiParam.INITIAL_PAGE;

@Component
@RequiredArgsConstructor
public class ExistingCardAdapter implements ExistingCardProvider {
  private final PokemonTcgApi pokemonTcgApi;
  private final CardMapper mapper;

  //TODO ajouter du cache sur ce qu'on récupère de l'api pokemontcg.io

  @Override
  public Flux<Card> findAll() {
    return fetchAllPages()
        .flatMapIterable(PokemonTcgCardWrapperDTO::data)
        .map(mapper::toDomain);
  }

  private Flux<PokemonTcgCardWrapperDTO> fetchAllPages() {
    return pokemonTcgApi.findAllCards(INITIAL_PAGE)
        .expand(responseWrapper -> {
          var totalCount = responseWrapper.totalCount();
          var pageSize = responseWrapper.pageSize();
          var totalPages = (int) Math.ceil((double) totalCount / pageSize);

          var currentPage = responseWrapper.page();

          if (currentPage < totalPages) {
            return pokemonTcgApi.findAllCards(currentPage + 1);
          } else {
            return Mono.empty();
          }
        });
  }
}
