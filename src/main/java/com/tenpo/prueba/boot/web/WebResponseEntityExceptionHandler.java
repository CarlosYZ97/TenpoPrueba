package com.tenpo.prueba.boot.web;

import com.tenpo.prueba.boot.web.exception.CustomizableHttpResponseException;
import com.tenpo.prueba.boot.web.exception.WebException;
import com.tenpo.prueba.boot.web.message.WebMessageSource;
import com.tenpo.prueba.boot.web.model.WebResponseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public abstract class WebResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(WebResponseEntityExceptionHandler.class);
    protected final WebMessageSource webMessageSource;
    private static final String ERROR_INESPERADO = "ERROR INESPERADO";

    public WebResponseEntityExceptionHandler(WebMessageSource webMessageSource) {
        this.webMessageSource = webMessageSource;
    }

    @ExceptionHandler({WebException.class})
    protected ResponseEntity<Object> handlerWebCore(RuntimeException ex, WebRequest request) {
        return this.handleExceptionInternal(ex, null, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler({Exception.class})
    protected ResponseEntity<Object> handlerException(Exception  ex, WebRequest request) {
        return this.handleExceptionInternal(ex, null, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String errorCode = "default";
        String shortMessage = null;
        HttpStatus finalStatus = status;
        if (ex instanceof WebException) {
            WebException webException = (WebException)ex;
            errorCode = webException.getCode();
            shortMessage = webException.getShortMessage();
            if (webException.getHttpCode() != null) {
                finalStatus = HttpStatus.resolve(webException.getHttpCode());
            }
        }

        if (ex instanceof CustomizableHttpResponseException) {
            CustomizableHttpResponseException mainException = (CustomizableHttpResponseException)ex;
            HttpStatus httpStatus = mainException.getStatus() == null ? status : mainException.getStatus();
            return new ResponseEntity(mainException.getPayload(), headers, httpStatus);
        } else {
            WebResponseEntity<Object> webResponseEntity = new WebResponseEntity();
            WebMessageSource.Message message = this.webMessageSource.getMessage(errorCode);
            webResponseEntity.setMensaje(message.getMensaje());
            log.error("code: [{}] message: [{}]", new Object[]{webResponseEntity.getMensaje(), ex});
            return new ResponseEntity(webResponseEntity, headers, finalStatus);
        }
    }

}