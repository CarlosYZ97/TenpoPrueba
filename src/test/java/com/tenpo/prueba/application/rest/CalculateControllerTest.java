package com.tenpo.prueba.application.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tenpo.prueba.application.dto.CalculateRequestDto;
import com.tenpo.prueba.application.dto.CalculateResponseDto;
import com.tenpo.prueba.application.service.CalculateService;
import com.tenpo.prueba.domain.model.History;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CalculateController.class)
class CalculateControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CalculateService calculateService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testCalculate() throws Exception {
        // Arrange
        CalculateRequestDto request = new CalculateRequestDto(10.0, 5.0);
        CalculateResponseDto response = new CalculateResponseDto(10.0, 5.0, 20.0, 18.0);

        Mockito.when(calculateService.calculate(any(CalculateRequestDto.class))).thenReturn(response);

        // Act & Assert
        mockMvc.perform(post("/api/v1/calculator/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.number1").value(10.0))
                .andExpect(jsonPath("$.data.number2").value(5.0))
                .andExpect(jsonPath("$.data.percentage").value(20.0))
                .andExpect(jsonPath("$.data.result").value(18.0));
    }

    @Test
    void testGetHistory() throws Exception {
        CalculateRequestDto request = new CalculateRequestDto(10.0, 5.0);

        History history = History.builder()
                .path("/api/v1/calculator/calculate")
                .request(request.toString())
                .result("18.0")
                .timestamp(LocalDateTime.now())
                .build();

        List<History> historyList = Collections.singletonList(history);

        Mockito.when(calculateService.getAllHistory()).thenReturn(historyList);

        // Act & Assert
        mockMvc.perform(get("/api/v1/calculator/history"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1));
    }
}
