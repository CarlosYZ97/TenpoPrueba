package com.tenpo.prueba.boot.constant;

import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class PathConstant {
    public static final String CALCULATE_PERCENTAGE = "/calculate";
    public static final String GET_HISTORY = "/history";
}
