package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.dto.result;

import com.beuben.pokemontcgcollectorbackend.collection.domain.Condition;
import com.beuben.pokemontcgcollectorbackend.collection.domain.Estimation;
import com.beuben.pokemontcgcollectorbackend.collection.domain.Language;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record LooseCardDTO(
    Long id,
    Long collectorId,
    String label,
    Long cardId,
    Language language,
    boolean firstEdition,
    boolean reverseHolo,
    Condition condition,
    Estimation estimation,
    String picturesUrl,
    String comment,
    LocalDateTime creationDate,
    boolean fromMasterSet,
    Long masterSetId) {
}
