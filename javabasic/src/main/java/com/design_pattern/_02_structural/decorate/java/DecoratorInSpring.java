package com.design_pattern._02_structural.decorate.java;

import org.springframework.beans.factory.xml.BeanDefinitionDecorator;
import org.springframework.http.server.reactive.ServerHttpRequestDecorator;
import org.springframework.http.server.reactive.ServerHttpResponseDecorator;
import org.springframework.web.server.WebFilter;

public class DecoratorInSpring {
    public static void main(String[] args) {
        // 빈 설정 데코레이터
        // 직접 쓸일이 없고, 스프링의 인프라의 structual
        BeanDefinitionDecorator decorator;

        // 웹플럭스 HTTP 요청/응답 데코레이터
        // 웹플럭스 쓰는 사람이면 쓸수 있음.
        // ServerHttpRequest, Response를 커스트 마이징
        // React의 웹필터(WebFilter)를 상속받아서 만든다음에 ServerHttpRequest로 감싼다.
        // 본문을 logging, 의심스러운 요청 처리 않는다거나 wrapper 기능으로 처리 한다.
        ServerHttpRequestDecorator httpRequestDecorator;
        ServerHttpResponseDecorator httpResponseDecorator;
    }
}
