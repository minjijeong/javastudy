package com.design_pattern._02_structural.proxy.example;

import com.design_pattern._02_structural.proxy.DefaultGameService;
import com.design_pattern._02_structural.proxy.GameService;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyInJava {
    public static void main(String[] args) {
        // 런타임시 proxy 적용, 객체 생성 되는 것 = 다이나믹 프록시
        ProxyInJava proxyInJava = new ProxyInJava();
        proxyInJava.dynamicProxy();
    }

    private void dynamicProxy() {
        GameService gameServiceProxy = getGameServiceProxy(new DefaultGameService());
        gameServiceProxy.startGame();
    }

    private GameService getGameServiceProxy(GameService target) {
//        return (GameService) Proxy.newProxyInstance(this.getClass().getClassLoader(),
//                // 동적으로 생성되어야 하는 인터페이스 타입
//                new Class[]{GameService.class},(proxy, method, args) -> {
//                    System.out.println("hello dynamic proxy");
//                    method.invoke(target,args);
//                    return null;
//                });
        return (GameService) Proxy.newProxyInstance(this.getClass().getClassLoader(),
                // 동적으로 생성되어야 하는 인터페이스 타입
                new Class[]{GameService.class}, new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("hello dynamic proxy");
                        method.invoke(target,args); // method 실행 어떤거 할지, 파라미터 어떤거 줄지
                        return null;
                    }
                });
    }
}
