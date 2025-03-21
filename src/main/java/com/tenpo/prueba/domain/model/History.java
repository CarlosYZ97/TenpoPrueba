package com.tenpo.prueba.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class History {

    private Long id;
    private String request;
    private String path;
    private String result;
    private String error;
    private LocalDateTime timestamp;

}
