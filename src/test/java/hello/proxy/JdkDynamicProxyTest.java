package hello.proxy;

import hello.proxy.jdkDynamic.*;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

@Log4j2
public class JdkDynamicProxyTest {

    @Test
    void test1(){
        AInterface target = new AImpl();

        TimeInvocationHandler timeInvocationHandler = new TimeInvocationHandler(target);

        AInterface proxy = (AInterface)Proxy.newProxyInstance(AInterface.class.getClassLoader(),
                new Class[]{AInterface.class},
                timeInvocationHandler);

        proxy.call();
        log.info("targetClass={}", target.getClass());
        log.info("proxyClass={}", proxy.getClass());
    }
    @Test
    void test2(){
        BInterface target = new BImpl();

        TimeInvocationHandler timeInvocationHandler = new TimeInvocationHandler(target);

        BInterface proxy = (BInterface)Proxy.newProxyInstance(BInterface.class.getClassLoader(),
                new Class[]{BInterface.class},
                timeInvocationHandler);

        proxy.call();
        log.info("targetClass={}", target.getClass());
        log.info("proxyClass={}", proxy.getClass());
    }
}
