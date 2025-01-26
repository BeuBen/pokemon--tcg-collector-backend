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
  public GroupedOpenApi synchronization() {
    return GroupedOpenApi.builder()
        .group(SWAGGER_GROUP_SYNCHRO)
        .pathsToMatch(SWAGGER_PATH_SYNCHRO)
        .build();
  }

  @Bean
  public GroupedOpenApi catalog() {
    return GroupedOpenApi.builder()
        .group(SWAGGER_GROUP_CATALOG)
        .pathsToMatch(SWAGGER_PATH_CATALOG)
        .build();
  }
}
