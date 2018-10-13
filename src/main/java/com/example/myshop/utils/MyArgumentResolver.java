package com.example.myshop.utils;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class MyArgumentResolver implements HandlerMethodArgumentResolver {

    //원하는 타입인지 검증
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        if(parameter.getParameterType() == ServerInfo.class){
                return true;
        }
        return false;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        ServerInfo serverInfo = new ServerInfo();
        serverInfo.setIp("127.0.0.1");
        serverInfo.setPort(8080);
        return serverInfo;
    }
}
