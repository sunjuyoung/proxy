package hello.proxy.app.config.v2_dynamicProxy;

import hello.proxy.app.config.v2_dynamicProxy.handler.LogTraceBasicHandler;
import hello.proxy.app.config.v2_dynamicProxy.handler.LogTraceFilterHandler;
import hello.proxy.app.v1.*;
import hello.proxy.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Proxy;

@Configuration
public class DynamicProxyFilterConfig {

    private static final String[] PATTERNS = {"request","orderItem", "save"};

    @Bean
    public OrderControllerV1 orderControllerV1(LogTrace logTrace){
//        OrderControllerV1 orderControllerV1 =  new OrderControllerV1(orderServiceV1(logTrace));
//
//        OrderControllerV1 proxy = (OrderControllerV1) Proxy.newProxyInstance(OrderControllerV1.class.getClassLoader(),
//                new Class[]{OrderControllerV1.class},
//                new LogTraceBasicHandler(orderControllerV1,logTrace));
//        return proxy;

        return new OrderControllerV1(orderServiceV1(logTrace));
    }

    @Bean
    public OrderServiceV1 orderServiceV1(LogTrace logTrace){
        OrderServiceV1 orderServiceV1 = new OrderServiceV1Impl(orderRepositoryV1(logTrace));
        OrderServiceV1 proxy = (OrderServiceV1) Proxy.newProxyInstance(OrderServiceV1.class.getClassLoader(),
                new Class[]{OrderServiceV1.class},
                new LogTraceFilterHandler(orderServiceV1,logTrace,PATTERNS));
        return proxy;
    }

    @Bean
    public OrderRepositoryV1 orderRepositoryV1(LogTrace logTrace){
        OrderRepositoryV1 orderRepositoryV1 = new OrderRepositoryV1Impl();
        OrderRepositoryV1 proxy = (OrderRepositoryV1) Proxy.newProxyInstance(OrderRepositoryV1.class.getClassLoader(),
                new Class[]{OrderRepositoryV1.class},
                new LogTraceFilterHandler(orderRepositoryV1,logTrace,PATTERNS));
        return proxy;
    }
}
