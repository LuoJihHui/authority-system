package com.ljh.commons.config;

import com.ljh.commons.constant.ResponseBean;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 统一配置返回格式
 *
 * @author luojihui
 * @date 2019/9/11 15:15
 */
@EnableWebMvc
public class GlobalResponseConfig {

    @RestControllerAdvice
    static class ReturnResponseAdvice implements ResponseBodyAdvice<Object> {
        @Override
        public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
            return true;
        }

        @Override
        public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                      Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                      ServerHttpRequest request, ServerHttpResponse response) {
            if (body instanceof ResponseBean || body instanceof String || body instanceof ResponseEntity) {
                return body;
            }
            return new ResponseBean(body);
        }
    }
}
