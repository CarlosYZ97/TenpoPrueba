# Prueba

Microservicio de cálculo con porcentaje dinámico y registro asincrónico del historial de llamadas, construido con arquitectura hexagonal.

---

## 🧩 Tecnologías utilizadas

- Java 21
- Spring Boot 3.4.3
- Spring Web / Data JPA / Redis
- MapStruct
- PostgreSQL
- Swagger (springdoc-openapi 2.3.0)
- Arquitectura Hexagonal (DDD)
- Gradle

---

## 📁 Estructura del proyecto

```
prueba/
├── application/
│   ├── rest/
│   │   └── CalculateController.java
│   ├── dto/
│   │   ├── CalculateRequestDto.java
│   │   └── CalculateResponseDto.java
│   ├── service/
│   │   ├── impl/
│   │   │   └── CalculateServiceImpl.java
│   │   └── CalculateService.java
├── boot/
│   ├── config/
│   │   ├── advice/
│   │   │   └── CustomResponseBodyAdvice.java
│   │   ├── cache/
│   │   │   └── CacheConfig.java
│   │   ├── cors/
│   │   │   ├── CorsConfigurationSource.java
│   │   │   └── EnableCors.java
│   │   ├── property/
│   │   │   └── CorsProperties.java
│   │   ├── swagger/
│   │   │   └── SwaggerConfig.java
│   ├── constant/
│   │   ├── ErrorConstant.java
│   │   └── PathConstant.java
│   ├── web/
│   │   ├── exception/
│   │   │   ├── CustomizableHttpResponseException.java
│   │   │   ├── CustomResponseEntityExceptionHandler.java
│   │   │   └── WebException.java
│   │   ├── message/
│   │   │   └── WebMessageSource.java
│   │   ├── model/
│   │   │   ├── WebResponseEntity.java
│   │   │   ├── WebResponseBodyAdvice.java
│   │   │   └── WebResponseEntityExceptionHandler.java
├── domain/
│   ├── model/
│   │   └── History.java
│   ├── repository/
│   │   └── HistoryRepository.java
│   └── service/
│       ├── HistoryService.java
│       └── PercentageService.java
├── infrastructure/
│   ├── connector/
│   │   └── percentage/
│   │       └── PercentageClient.java
│   ├── dao/
│   │   ├── entity/
│   │   │   └── HistoryEntity.java
│   │   ├── mapper/
│   │   │   └── HistoryMapper.java
│   │   ├── repository/
│   │   │   └── HistoryRepositoryJpa.java
│   ├── repository/
│   │   └── HistoryRepositoryImpl.java
│   ├── service/
│   │   ├── HistoryServiceImpl.java
│   │   └── PercentageServiceImpl.java
├── PruebaApplication.java
├── resources/
│   └── application.yml
└── build.gradle

```

---

## 🚀 Cómo levantar el proyecto

1. Clonar el repo:

```bash
git clone https://github.com/CarlosYZ97/prueba.git
cd prueba
```

2. Ejecutar con Gradle:

```bash
./gradlew bootRun
```

3. Ver Swagger:

```
http://localhost:8080/swagger-ui/index.html
```

---

---

## 📝 Notas

- El guardado en base de datos se hace **de forma asíncrona** con `@Async`.
- Si quieres ver el cálculo: `POST /api/calculate`
