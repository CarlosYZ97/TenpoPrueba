package com.tenpo.prueba.boot.web.exception;

public class WebException extends RuntimeException{

    private String code;
    protected String shortMessage;
    protected Integer httpCode;

    public WebException(String code, String msg, Throwable e) {
        super(String.format("[%s] %s", code, msg), e);
        this.code = code;
    }

    public WebException(String code, String msg) {
        super(String.format("[%s] %s", code, msg));
        this.code = code;
    }

    public WebException(String code, String msg, String shortMessage) {
        super(String.format("[%s] %s", code, msg));
        this.code = code;
        this.shortMessage = shortMessage;
    }

    public WebException(String code) {
        super(String.format("[%s]", code));
        this.code = code;
    }

    public WebException(String code, Integer httpCode) {
        super(String.format("[%s]", code));
        this.code = code;
        this.httpCode = httpCode;
    }

    public WebException(String msg, Throwable e) {
        this("DEFAULT", msg, e);
    }

    public String getCode() {
        return this.code;
    }

    public String getShortMessage() {
        return this.shortMessage;
    }

    public Integer getHttpCode() {
        return this.httpCode;
    }

}