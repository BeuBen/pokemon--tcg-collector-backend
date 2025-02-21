package com.beuben.pokemontcgcollectorbackend.collection.infrastructure.in.rest.dto.result;

import com.beuben.pokemontcgcollectorbackend.collection.domain.Estimation;
import com.beuben.pokemontcgcollectorbackend.collection.domain.Grading;
import com.beuben.pokemontcgcollectorbackend.collection.domain.Language;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record GradedCardDTO(
    Long id,
    Long collectorId,
    String label,
    Long cardId,
    Language language,
    boolean firstEdition,
    boolean reverseHolo,
    Grading grading,
    Estimation estimation,
    String picturesUrl,
    String comment,
    LocalDateTime creationDate,
    boolean fromMasterSet,
    Long masterSetId) {
}
