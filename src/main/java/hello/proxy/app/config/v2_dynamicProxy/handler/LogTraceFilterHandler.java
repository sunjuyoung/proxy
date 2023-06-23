package hello.proxy.app.config.v2_dynamicProxy.handler;

import hello.proxy.trace.TraceStatus;
import hello.proxy.trace.logtrace.LogTrace;
import org.springframework.util.PatternMatchUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LogTraceFilterHandler implements InvocationHandler {

    private final Object target;
    private final LogTrace logTrace;
    private final String[] patterns;

    public LogTraceFilterHandler(Object target, LogTrace logTrace, String[] patterns) {
        this.target = target;
        this.logTrace = logTrace;
        this.patterns = patterns;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        
        //특정 메서드 이름이 매칭되는 경우에만 로직 실행
        String methodName = method.getName();
        //save , request, reques*
        if(!PatternMatchUtils.simpleMatch(patterns,methodName)){
            return method.invoke(target,args);
        }

        TraceStatus status = null;

        try {
            String message = method.getDeclaringClass().getSimpleName()+"."+method.getName()+"()";
            status = logTrace.begin(message);
            Object result = method.invoke(target, args); //call


            logTrace.end(status);
            return result;

        }catch (Exception e){
            throw e;
        }

    }
}
