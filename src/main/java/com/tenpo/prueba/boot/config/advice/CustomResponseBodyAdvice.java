package com.tenpo.prueba.boot.config.advice;

import com.tenpo.prueba.boot.web.WebResponseBodyAdvice;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ControllerAdvice;


@ControllerAdvice
@RequiredArgsConstructor
public class CustomResponseBodyAdvice extends WebResponseBodyAdvice {

}