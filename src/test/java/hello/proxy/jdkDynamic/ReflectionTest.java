package hello.proxy.jdkDynamic;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Log4j2
public class ReflectionTest {

    @Test
    void reflection(){

        Hello hello = new Hello();
        log.info("start");
        String result = hello.callA();
        log.info("result:{}",result);



        log.info("start");
        String result2 = hello.callB();
        log.info("result:{}",result2);
    }

    @Test
    void reflection1() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class className = Class.forName("hello.proxy.jdkDynamic.ReflectionTest$Hello");


        Hello target = new Hello();
        Method methodCallA = className.getMethod("callA");
        Object result1 =  methodCallA.invoke(target); //target에 있는 메서드(callA)를 호출한다
        log.info("result1:{}",result1);

        Method methodCallB = className.getMethod("callB");
        Object result2 =  methodCallB.invoke(target); //target에 있는 메서드(callA)를 호출한다
        log.info("result1:{}",result2);

    }

    @Test
    void reflection2() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class className = Class.forName("hello.proxy.jdkDynamic.ReflectionTest$Hello");

        Hello target = new Hello();
        Method methodCallA = className.getMethod("callA");
        Method methodCallB = className.getMethod("callB");
        dynamicCall(methodCallA,target);
        dynamicCall(methodCallB,target);

        //클래스나 메서드정보를 동적으로 변경할 수 있다.

        // 해당 코드를 직접 실행하는
        //시점에 발생하는 오류인 런타임 오류가 발생한다.

    }

    private void dynamicCall(Method method, Object target) throws InvocationTargetException, IllegalAccessException {
        log.info("start");
    //    String result = hello.callA();
        Object result = method.invoke(target);
        log.info("result:{}",result);
    }

    static class Hello{
        public String callA(){
            return "A";
        }
        public String callB(){
            return "B";
        }
    }
}
