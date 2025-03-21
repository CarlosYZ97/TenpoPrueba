package com.tenpo.prueba.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CalculateResponseDto {

    private double number1;
    private double number2;
    private double percentage;
    private double result;

}
