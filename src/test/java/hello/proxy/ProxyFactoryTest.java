package hello.proxy;

import hello.proxy.cglib.TimeMethodInterceptor;
import hello.proxy.common.ConcreteService;
import hello.proxy.common.ServiceImpl;
import hello.proxy.common.ServiceInterface;
import hello.proxy.common.advice.TimeAdvice;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.AopUtils;

@Log4j2
public class ProxyFactoryTest {


    @Test
    @DisplayName("proxyTargetClass 옵션을 사용, 항상 cglib를 사용한다")
    void test3() {
        ServiceInterface target = new ServiceImpl();
        ProxyFactory proxyFactory =
                new ProxyFactory(target);
        proxyFactory.setProxyTargetClass(true); // 항상 cglib를 사용한다.
        //service interface가 있지만 ServiceImpl를 상속받아서 cglib를 사용한다.

        proxyFactory.addAdvice(new TimeAdvice());
        ServiceInterface proxy = (ServiceInterface) proxyFactory.getProxy();
        log.info("targetClass={}", target.getClass());
        log.info("proxyClass={}", proxy.getClass());

        proxy.save();

        //스프링 팩토리 확인
        Assertions.assertTrue(AopUtils.isAopProxy(proxy));
        Assertions.assertTrue(AopUtils.isJdkDynamicProxy(proxy)); //jdk dynamic proxy다.
        Assertions.assertFalse(AopUtils.isCglibProxy(proxy)); //cglib proxy가 아니다.
    }

    @Test
    @DisplayName("인터페이스가 있으면 jdk dynamic proxy를 사용한다.")
    void test() {
        ServiceInterface target = new ServiceImpl();
        ProxyFactory proxyFactory =
                new ProxyFactory(target);

        proxyFactory.addAdvice(new TimeAdvice());
        ServiceInterface proxy = (ServiceInterface) proxyFactory.getProxy();
        log.info("targetClass={}", target.getClass());
        log.info("proxyClass={}", proxy.getClass());

        proxy.save();

        //스프링 팩토리 확인
        Assertions.assertTrue(AopUtils.isAopProxy(proxy));
        Assertions.assertTrue(AopUtils.isJdkDynamicProxy(proxy)); //jdk dynamic proxy다.
        Assertions.assertFalse(AopUtils.isCglibProxy(proxy)); //cglib proxy가 아니다.
    }

    @Test
    @DisplayName("구체클래스 있으면 cglib를 사용한다.")
    void test2() {
        ConcreteService target = new ConcreteService();
        ProxyFactory proxyFactory =
                new ProxyFactory(target);

        proxyFactory.addAdvice(new TimeAdvice());
        ConcreteService proxy = (ConcreteService) proxyFactory.getProxy();
        log.info("targetClass={}", target.getClass());
        log.info("proxyClass={}", proxy.getClass());

        proxy.call();

        //스프링 팩토리 확인
        Assertions.assertTrue(AopUtils.isAopProxy(proxy));
        Assertions.assertFalse(AopUtils.isJdkDynamicProxy(proxy)); //jdk dynamic proxy확인
        Assertions.assertTrue(AopUtils.isCglibProxy(proxy)); //cglib proxy 확인
    }

}
