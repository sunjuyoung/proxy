package hello.proxy;

import hello.proxy.cglib.TimeMethodInterceptor;
import hello.proxy.common.ConcreteService;
import org.junit.jupiter.api.Test;
import org.springframework.cglib.proxy.Enhancer;

public class CglibTest {

    @Test
    public void test(){
        ConcreteService concreteService = new ConcreteService();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(ConcreteService.class);
        enhancer.setCallback(new TimeMethodInterceptor(concreteService));
        ConcreteService o = (ConcreteService)enhancer.create();
        o.call();

    }
}
