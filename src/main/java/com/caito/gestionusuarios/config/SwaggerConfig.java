package com.caito.gestionusuarios.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi api(){
        return GroupedOpenApi.builder()
                .group("Gestion-Usuarios")
                .packagesToScan("com.caito")
                .build();
    }

    @Bean
    public OpenAPI springShopOpemapi(){
        return new OpenAPI()
                .info(new Info().title("Gestion Usuarios Api")
                        .description("Gestor para el manejo de usuarios")
                        .version("v1.0"));

    }
}
