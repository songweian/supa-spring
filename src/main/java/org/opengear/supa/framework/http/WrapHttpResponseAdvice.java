package org.opengear.supa.framework.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.opengear.supa.framework.common.UniResult;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
@RequiredArgsConstructor
public class WrapHttpResponseAdvice implements ResponseBodyAdvice<Object> {

    private final ObjectMapper objectMapper;

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        IgnoreWrapResult methodAnnotation = returnType.getMethodAnnotation(IgnoreWrapResult.class);
        if (methodAnnotation != null) {
            return false;
        }
        return true;
    }

    @SneakyThrows
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (!selectedContentType.includes(MediaType.APPLICATION_JSON)) {
            return body;
        }
        if(body == null){
            return UniResult.ofOk();
        }
        if (body instanceof String) {
            return objectMapper.writeValueAsString(UniResult.ofOk(body));
        }
        if (body instanceof UniResult uniResult) {
            return uniResult;
        }
        return UniResult.ofOk(body);
    }

}