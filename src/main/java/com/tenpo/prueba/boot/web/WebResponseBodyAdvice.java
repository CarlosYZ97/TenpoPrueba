package com.tenpo.prueba.boot.web;
import com.tenpo.prueba.boot.web.model.WebResponseEntity;
import org.springframework.core.MethodParameter;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

public abstract class WebResponseBodyAdvice implements ResponseBodyAdvice<Object> {
    public WebResponseBodyAdvice() {
    }

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(@Nullable Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (request.getURI().getPath().startsWith("/api/") && !(body instanceof WebResponseEntity) && !(body instanceof InputStreamResource)) {
            WebResponseEntity webResponseEntity = new WebResponseEntity();
            webResponseEntity.setData(body);
            return webResponseEntity;
        } else {
            return body;
        }
    }
}

