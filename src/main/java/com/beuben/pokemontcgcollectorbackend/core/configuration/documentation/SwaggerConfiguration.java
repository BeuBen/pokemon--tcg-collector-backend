package com.beuben.pokemontcgcollectorbackend.core.configuration.documentation;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.beuben.pokemontcgcollectorbackend.core.util.Constants.*;

@Configuration
public class SwaggerConfiguration {

  @Bean
  public OpenAPI customOpenApi(@Value("${springdoc.version}") final String appVersion) {
    return new OpenAPI()
        .info(new Info()
            .title("Pokémon TCG collector backend API")
            .version(appVersion));
  }

  @Bean
  public GroupedOpenApi actuator() {
    return GroupedOpenApi.builder()
        .group(SWAGGER_GROUP_ACTUATOR)
        .pathsToMatch(SWAGGER_PATH_ACTUATOR)
        .build();
  }

  @Bean
  public GroupedOpenApi catalog() {
    return GroupedOpenApi.builder()
        .group(SWAGGER_GROUP_CATALOG)
        .pathsToMatch(SWAGGER_PATH_CATALOG)
        .build();
  }

  @Bean
  public GroupedOpenApi collection() {
    return GroupedOpenApi.builder()
        .group(SWAGGER_GROUP_COLLECTION)
        .pathsToMatch(SWAGGER_PATH_COLLECTION)
        .build();
  }

  @Bean
  public GroupedOpenApi goodies() {
    return GroupedOpenApi.builder()
        .group(SWAGGER_GROUP_GOODIES)
        .pathsToMatch(SWAGGER_PATH_GOODIES)
        .build();
  }

  @Bean
  public GroupedOpenApi gradedCard() {
    return GroupedOpenApi.builder()
        .group(SWAGGER_GROUP_GRADED_CARD)
        .pathsToMatch(SWAGGER_PATH_GRADED_CARD)
        .build();
  }

  @Bean
  public GroupedOpenApi looseCard() {
    return GroupedOpenApi.builder()
        .group(SWAGGER_GROUP_LOOSE_CARD)
        .pathsToMatch(SWAGGER_PATH_LOOSE_CARD)
        .build();
  }

  @Bean
  public GroupedOpenApi masterSet() {
    return GroupedOpenApi.builder()
        .group(SWAGGER_GROUP_MASTER_SET)
        .pathsToMatch(SWAGGER_PATH_MASTER_SET)
        .build();
  }

  @Bean
  public GroupedOpenApi sealed() {
    return GroupedOpenApi.builder()
        .group(SWAGGER_GROUP_SEALED)
        .pathsToMatch(SWAGGER_PATH_SEALED)
        .build();
  }

  @Bean
  public GroupedOpenApi synchronization() {
    return GroupedOpenApi.builder()
        .group(SWAGGER_GROUP_SYNCHRO)
        .pathsToMatch(SWAGGER_PATH_SYNCHRO)
        .build();
  }
}
