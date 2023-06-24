package hello.proxy.common.advice;

import lombok.extern.log4j.Log4j2;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

@Log4j2
public class TimeAdvice implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        log.info("TimeAdvice.invoke");
        long startTime = System.currentTimeMillis();

        Object result = invocation.proceed(); //target 알아서 찾아서 실행해줌

        long endTime = System.currentTimeMillis();


        long resultTime = endTime - startTime;

        return resultTime;
    }
}
