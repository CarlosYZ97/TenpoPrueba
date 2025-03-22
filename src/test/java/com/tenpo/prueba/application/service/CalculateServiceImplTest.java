package com.tenpo.prueba.application.service;

import com.tenpo.prueba.application.dto.CalculateRequestDto;
import com.tenpo.prueba.application.dto.CalculateResponseDto;
import com.tenpo.prueba.application.service.impl.CalculateServiceImpl;
import com.tenpo.prueba.domain.model.History;
import com.tenpo.prueba.domain.service.HistoryService;
import com.tenpo.prueba.domain.service.PercentageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class CalculateServiceImplTest {

    @Mock
    private HistoryService historyService;

    @Mock
    private PercentageService percentageService;

    @InjectMocks
    private CalculateServiceImpl calculateService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCalculateSuccess() {
        CalculateRequestDto request = new CalculateRequestDto(10, 20);
        when(percentageService.getPercentage()).thenReturn(10.0);

        CalculateResponseDto response = calculateService.calculate(request);

        assertEquals(10, response.getNumber1());
        assertEquals(20, response.getNumber2());
        assertEquals(10.0, response.getPercentage());
        assertEquals(33.0, response.getResult(), 0.001);

        verify(historyService, times(1)).save(any(History.class));
    }

    @Test
    void testCalculateErrorException() {
        CalculateRequestDto request = new CalculateRequestDto(10, 20);
        when(percentageService.getPercentage()).thenThrow(new RuntimeException("Servicio Falló"));

        Exception exception = assertThrows(RuntimeException.class, () -> {
            calculateService.calculate(request);
        });

        assertEquals("Servicio Falló", exception.getMessage());
        verify(historyService, times(1)).save(any(History.class));
    }

    @Test
    void testGetAllHistory() {
        when(historyService.getAll()).thenReturn(List.of());

        List<History> result = calculateService.getAllHistory();

        assertNotNull(result);
    }
}
