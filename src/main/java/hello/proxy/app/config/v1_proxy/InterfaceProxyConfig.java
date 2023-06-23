package hello.proxy.app.config.v1_proxy;

import hello.proxy.app.config.v1_proxy.interface_proxy.OrderRepositoryInterfaceProxy;
import hello.proxy.app.config.v1_proxy.interface_proxy.OrderServiceInterfaceProxy;
import hello.proxy.app.v1.*;
import hello.proxy.app.v2.OrderControllerV2;
import hello.proxy.app.v2.OrderRepositoryV2;
import hello.proxy.app.v2.OrderServiceV2;
import hello.proxy.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InterfaceProxyConfig {

//    @Bean
//    public OrderControllerV1 orderControllerV1(LogTrace logTrace){
//        return new OrderControllerV1(orderServiceV1(logTrace));
//    }
//
//    //프록시를 생성하고 프록시를 실제 스프링 빈 대신 등록한다. 실제 객체는 스프링 빈으로 등록하지 않는다.
////    proxy -> target
////    orderServiceInterfaceProxy -> orderServiceV1Impl
//    @Bean
//    public OrderServiceV1 orderServiceV1(LogTrace logTrace){
//        OrderServiceV1Impl orderServiceV1 = new OrderServiceV1Impl(orderRepositoryV1(logTrace));
//        return new OrderServiceInterfaceProxy(orderServiceV1,logTrace);
//    }
//
//    @Bean
//    public OrderRepositoryV1 orderRepositoryV1(LogTrace logTrace){
//        OrderRepositoryV1Impl orderRepositoryV1 = new OrderRepositoryV1Impl();
//        return new OrderRepositoryInterfaceProxy(orderRepositoryV1,logTrace);
//    }
}
