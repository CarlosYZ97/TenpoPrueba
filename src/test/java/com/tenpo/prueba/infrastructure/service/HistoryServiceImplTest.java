package com.tenpo.prueba.infrastructure.service;

import com.tenpo.prueba.domain.model.History;
import com.tenpo.prueba.domain.repository.HistoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class HistoryServiceImplTest {

    private HistoryRepository historyRepository;
    private HistoryServiceImpl historyService;

    @BeforeEach
    void setUp() {
        historyRepository = mock(HistoryRepository.class);
        historyService = new HistoryServiceImpl(historyRepository);
    }

    @Test
    void testSaveHistoryRepository() {
        History history = History.builder()
                .request("CalculateRequestDto(number1=5.0, number2=20.0)")
                .path("/calculate")
                .result("4")
                .timestamp(LocalDateTime.now())
                .build();

        historyService.save(history);

        verify(historyRepository, times(1)).save(history);
    }

    @Test
    void testGetAllShouldReturnAllHistories() {
        List<History> mockHistoryList = List.of(
                History.builder().request("CalculateRequestDto(number1=5.0, number2=20.0)").path("/calculate").result("2").timestamp(LocalDateTime.now()).build()
        );
        when(historyRepository.getAll()).thenReturn(mockHistoryList);

        List<History> result = historyService.getAll();

        assertThat(result).isEqualTo(mockHistoryList);
        verify(historyRepository, times(1)).getAll();
    }
}
