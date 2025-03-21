package com.tenpo.prueba.boot.web.exception;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;

public class CustomizableHttpResponseException extends RuntimeException {

    private final HttpEntity payload;
    private HttpStatus status;

    public CustomizableHttpResponseException(HttpEntity payload, HttpStatus status) {
        this.payload = payload;
        this.status = status;
    }

    public CustomizableHttpResponseException(HttpEntity payload) {
        this.payload = payload;
    }

    public HttpEntity getPayload() {
        return this.payload;
    }

    public HttpStatus getStatus() {
        return this.status;
    }

}