package com.tenpo.prueba.boot.config.cors;

import com.tenpo.prueba.boot.config.property.CorsProperties;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import({CorsConfigurationSource.class, CorsProperties.class})
public @interface EnableCors {
}
