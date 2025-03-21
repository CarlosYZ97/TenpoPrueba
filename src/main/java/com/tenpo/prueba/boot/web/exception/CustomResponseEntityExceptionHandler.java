package com.tenpo.prueba.boot.web.exception;

import com.tenpo.prueba.boot.web.WebResponseEntityExceptionHandler;
import com.tenpo.prueba.boot.web.message.WebMessageSource;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Order(Ordered.HIGHEST_PRECEDENCE)
@Hidden
@RestControllerAdvice
public class CustomResponseEntityExceptionHandler extends WebResponseEntityExceptionHandler {

    public CustomResponseEntityExceptionHandler(WebMessageSource webMessageSource) {
        super(webMessageSource);
    }

}