package com.tenpo.prueba.application.service;

import com.tenpo.prueba.application.dto.CalculateRequestDto;
import com.tenpo.prueba.application.dto.CalculateResponseDto;
import com.tenpo.prueba.domain.model.History;

import java.util.List;

public interface CalculateService {
    CalculateResponseDto calculate(CalculateRequestDto calculationRequestDto);
    List<History> getAllHistory();
}
