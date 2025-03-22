# Prueba

Microservicio de cálculo con porcentaje dinámico y registro asincrónico del historial de llamadas, construido con arquitectura hexagonal.

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

### 1. Compilar y correr tests

```bash
./gradlew clean build test
```

### 2. Ejecutar en modo local

En tu IDE (por ejemplo IntelliJ), asegúrate de configurar el perfil local:

1. Ve a "Run Configurations" o "Edit Configurations"
2. En VM options agrega:

```bash
-Dspring.profiles.active=local
```

### 3. Construir la imagen Docker

```bash
docker build -t tenpo-app .
```

### 4. Levantar todos los servicios (PostgreSQL, Redis y la Aplicación)

```bash
docker-compose up --build
```

> Verifica que no haya contenedores locales en los puertos 5435 (Postgres) o 6379 (Redis)

### 5. Acceso a la API

- Swagger: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
- POST `/api/v1/calculator/calculate`
- GET `/api/v1/calculator/history`

---

## 🧪 Tests

Se ejecutan automáticamente con el build:

```bash
./gradlew test
```

## 📥 Descargar proyecto

Puedes clonar este repositorio:

```bash
git clone https://github.com/CarlosYZ97/TenpoPrueba.git
```

---

---

## 📝 Notas

- El guardado en base de datos se hace **de forma asíncrona** con `@Async`.
- Si quieres ver el cálculo: `POST /api/calculate`
