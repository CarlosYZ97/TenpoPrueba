package com.tenpo.prueba.application.rest;

import com.tenpo.prueba.application.dto.CalculateRequestDto;
import com.tenpo.prueba.application.dto.CalculateResponseDto;
import com.tenpo.prueba.application.service.CalculateService;
import com.tenpo.prueba.boot.constant.PathConstant;
import com.tenpo.prueba.domain.model.History;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/calculator")
@RequiredArgsConstructor
public class CalculateController {

    private final CalculateService calculationService;

    @GetMapping(PathConstant.CALCULATE_PERCENTAGE)
    @Operation(summary = "Calcula (a + b) aplicando un porcentaje dinámico", description = "Resultado de porcentaje se guarda en un historial de llamadas")
    public CalculateResponseDto calculate(@RequestBody CalculateRequestDto calculationRequestDto) {
        return calculationService.calculate(calculationRequestDto);
    }

    @GetMapping(PathConstant.GET_HISTORY)
    @Operation(summary = "Obtiene el historial de operaciones", description = "Se obtiene todo el historial de llamados")
    public List<History> getHistory() {
        return calculationService.getAllHistory();
    }

}
