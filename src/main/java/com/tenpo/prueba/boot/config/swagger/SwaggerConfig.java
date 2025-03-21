package com.tenpo.prueba.boot.config.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI api() {
        return new OpenAPI()
                .info(new Info()
                        .title("Tenpo Calculator API")
                        .description("Servicio de cálculo con porcentaje dinámico y cache")
                        .version("1.0.0"));
    }
}