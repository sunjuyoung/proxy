package hello.proxy.cglib;

import hello.proxy.trace.logtrace.LogTrace;
import lombok.extern.log4j.Log4j2;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

@Log4j2
public class TimeMethodInterceptor implements MethodInterceptor {

    private final Object target;


    public TimeMethodInterceptor(Object target) {
        this.target = target;

    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        long startTime = System.currentTimeMillis();

        Object result = methodProxy.invoke(target, args);

        long endTime = System.currentTimeMillis();

        long timeMs = endTime - startTime;

        log.info("TimeMethodInterceptor.intercept timeMs = " + timeMs + "ms");



        return result;
    }
}
