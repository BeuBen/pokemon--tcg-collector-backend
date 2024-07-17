package com.beuben.pokemontcgcollectorbackend.core.configuration.application.mapstruct;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.MapperConfig;
import org.mapstruct.ReportingPolicy;

@MapperConfig(
    injectionStrategy = InjectionStrategy.CONSTRUCTOR,
    componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MapperConfiguration {
}
