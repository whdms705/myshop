package com.example.myshop.config;

import com.example.myshop.security.LoginUserArgumentResolver;
import com.example.myshop.utils.MyArgumentResolver;
import com.example.myshop.utils.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

//webMvcConfigurer를 구현하는 클래스는 Spring mvc 를 확장할 수 있는 기능을 가진다.

@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor());
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new MyArgumentResolver());
        resolvers.add(new LoginUserArgumentResolver());
    }
}

/*
WebMvcConfigurer는 인터페이스인데 구현을 안해줘도 에러가 안나는 이유

자바8 부터는 default 메소드라는 기능이 추가됨.
인터페이스도 메소드를 구현할 수 있다.



Interface가 있고, 해당 Interface를 구현해야 한다.
이 인터페이스의 모든 기능은 구현할 필요 없고 , 필요한 기능만 구현하고 싶다면 어떻게 할까?

예를 들어 사용자가 Myinterface 라는 interface 를 만들었다.
해당 인터페이스가 구현해야 하는 메서드 5개를 가지고 있다.

이런 불편함을 해결하고자 MyInterface를 구현한 MyAdapter를 구현했다.


class Mybean inplements MyInterface{
..5개의 메소드를 구현
}

 */
