package com.tenpo.prueba.infrastructure.connector.percentage;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import java.util.Random;

@Component
@Slf4j
public class PercentageClient {

    private final Random random = new Random();

    public Double getPercentage() {
        int chance = random.nextInt(10);
        if (chance < 7) {
            double value = 10.0 + random.nextDouble() * 10;
            log.info("[PercentageClient] - getPercentage: retorna valor : {} ", value);
            return value;
        } else {
            log.warn("[PercentageClient] - getPercentage: Error de servicio para obtener porcentaje");
            throw new RuntimeException("Error de servicio para obtener porcentaje");
        }
    }

}
