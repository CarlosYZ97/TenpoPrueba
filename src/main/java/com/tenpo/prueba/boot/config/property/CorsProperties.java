package com.tenpo.prueba.boot.config.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import java.util.Collections;
import java.util.List;

@Data
@Validated
@ConfigurationProperties(prefix = "com.tenpo.prueba.boot.config.cors")
public class CorsProperties {
    private static final List<String> allow = Collections.singletonList("*");
    private List<String> allowedOrigins = allow;
    private List<String> allowedMethods = allow;
    private List<String> allowedHeaders = allow;
    private boolean allowCredentials = false;
    private String path = "/**";
}
