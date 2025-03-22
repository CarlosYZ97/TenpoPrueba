package com.tenpo.prueba.infrastructure.service;

import com.tenpo.prueba.boot.constant.ErrorConstant;
import com.tenpo.prueba.boot.web.exception.WebException;
import com.tenpo.prueba.domain.service.PercentageService;
import com.tenpo.prueba.infrastructure.connector.percentage.PercentageClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PercentageServiceImpl implements PercentageService {

    private final PercentageClient percentageClient;
    private final CacheManager cacheManager;
    private static final String CACHE_NAME = "percentage";
    private static final String CACHE_KEY = "current";

    @Override
    public Double getPercentage() {
        try {
            Double percentage = percentageClient.getPercentage();
            cacheManager.getCache(CACHE_NAME).put(CACHE_KEY, percentage);
            return percentage;
        } catch (Exception e){
            Cache.ValueWrapper cached = cacheManager.getCache(CACHE_NAME).get(CACHE_KEY);
            log.info("[PercentageServiceImpl] - getPercentage: retorna valor de caché : {} ", cached);
            if (cached != null) return (Double) cached.get();
            log.info("[PercentageServiceImpl] - getPercentage: retorna error controlado");
            throw new WebException(ErrorConstant.ERROR_GET_PERCENTAGE , HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
    }
}
