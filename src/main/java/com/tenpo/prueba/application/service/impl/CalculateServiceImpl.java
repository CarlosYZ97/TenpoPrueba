package com.tenpo.prueba.application.service.impl;

import com.tenpo.prueba.application.dto.CalculateRequestDto;
import com.tenpo.prueba.application.dto.CalculateResponseDto;
import com.tenpo.prueba.boot.constant.PathConstant;
import com.tenpo.prueba.domain.model.History;
import com.tenpo.prueba.domain.service.HistoryService;
import com.tenpo.prueba.domain.service.PercentageService;
import com.tenpo.prueba.application.service.CalculateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CalculateServiceImpl implements CalculateService {

    private final HistoryService historyService;
    private final PercentageService percentageService;

    @Override
    public CalculateResponseDto calculate(CalculateRequestDto calculationRequestDto) {
        try {
            double percentage = percentageService.getPercentage();
            double result = (calculationRequestDto.getNumber1() + calculationRequestDto.getNumber2()) * (1 + percentage / 100);

            historyService.save(History.builder()
                    .request(calculationRequestDto.toString())
                    .path(PathConstant.CALCULATE_PERCENTAGE)
                    .result(String.valueOf(result))
                    .createDate(LocalDateTime.now())
                    .build());

            return CalculateResponseDto.builder()
                    .number1(calculationRequestDto.getNumber1())
                    .number2(calculationRequestDto.getNumber2())
                    .percentage(percentage)
                    .result(result)
                    .build();
        } catch (Exception ex) {
            historyService.save(History.builder()
                    .request(calculationRequestDto.toString())
                    .path(PathConstant.CALCULATE_PERCENTAGE)
                    .error(ex.getMessage())
                    .createDate(LocalDateTime.now())
                    .build());
            throw ex;
        }

    }

    @Override
    public List<History> getAllHistory() {
        return historyService.getAll();
    }

}
