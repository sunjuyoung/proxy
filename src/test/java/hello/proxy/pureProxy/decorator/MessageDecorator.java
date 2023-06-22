package hello.proxy.pureProxy.decorator;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class MessageDecorator implements Component{

    private Component component;

    public MessageDecorator(Component component) {
        this.component = component;
    }

    @Override
    public String operation() {
        log.info("MessageDecorator.operation()");
        String operation = component.operation();
        String decoResult = operation + "************";
        return decoResult;
    }
}
