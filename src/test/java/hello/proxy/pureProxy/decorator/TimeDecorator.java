package hello.proxy.pureProxy.decorator;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class TimeDecorator implements Component{

    private Component component;

    public TimeDecorator(Component component) {
        this.component = component;
    }

    @Override
    public String operation() {
        log.info("TimeDecorator.operation()");
        long start = System.currentTimeMillis();
        String operation = component.operation();
        long end = System.currentTimeMillis();
        long result = end - start;
        log.info("TimeDecorator.종료 took {} ms", result);
        return operation;
    }
}
