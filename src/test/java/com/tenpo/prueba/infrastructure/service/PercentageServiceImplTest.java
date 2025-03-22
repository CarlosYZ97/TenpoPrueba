package com.tenpo.prueba.infrastructure.service;

import com.tenpo.prueba.boot.constant.ErrorConstant;
import com.tenpo.prueba.boot.web.exception.WebException;
import com.tenpo.prueba.infrastructure.connector.percentage.PercentageClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PercentageServiceImplTest {

    @Mock
    private PercentageClient percentageClient;

    @Mock
    private CacheManager cacheManager;

    @Mock
    private Cache cache;

    @InjectMocks
    private PercentageServiceImpl percentageService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        when(cacheManager.getCache("percentage")).thenReturn(cache);
    }

    @Test
    void testGetPercentageSuccess() {
        Double expectedPercentage = 15.0;
        when(percentageClient.getPercentage()).thenReturn(expectedPercentage);

        Double result = percentageService.getPercentage();

        assertEquals(expectedPercentage, result);
        verify(cache).put("current", expectedPercentage);
    }

    @Test
    void testGetPercentageFromCacheWhenClientFails() {
        Double cachedPercentage = 12.5;
        when(percentageClient.getPercentage()).thenThrow(new RuntimeException("Timeout"));
        when(cache.get("current")).thenReturn(() -> cachedPercentage);

        Double result = percentageService.getPercentage();

        assertEquals(cachedPercentage, result);
        verify(cache).get("current");
    }

    @Test
    void testGetPercentageThrowsExceptionWhenClientFailsAndCacheEmpty() {
        when(percentageClient.getPercentage()).thenThrow(new RuntimeException("Timeout"));
        when(cache.get("current")).thenReturn(null);

        WebException exception = assertThrows(WebException.class, () -> percentageService.getPercentage());
        assertEquals(ErrorConstant.ERROR_GET_PERCENTAGE, exception.getCode());
    }
}
