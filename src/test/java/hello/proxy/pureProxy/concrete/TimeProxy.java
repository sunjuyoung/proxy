package hello.proxy.pureProxy.concrete;


import lombok.extern.log4j.Log4j2;

@Log4j2
public class TimeProxy extends ConcreteLogic{

    private ConcreteLogic concreteLogic;

    public TimeProxy(ConcreteLogic concreteLogic) {
        this.concreteLogic = concreteLogic;
    }

    @Override
    public String operation() {
        log.info("TimeProxy.operation()");
        long start = System.currentTimeMillis();
        String operation = concreteLogic.operation();
        long end = System.currentTimeMillis();
        long result = end - start;
        log.info("TimeProxy.종료 took {} ms", result);
        return operation;
    }
}
