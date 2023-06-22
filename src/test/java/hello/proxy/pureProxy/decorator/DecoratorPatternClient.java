package hello.proxy.pureProxy.decorator;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class DecoratorPatternClient {

    private Component component;

    public DecoratorPatternClient(Component component) {
        this.component = component;
    }

    public void execute(){

        String operation = component.operation();
        log.info(operation);
    }
}
