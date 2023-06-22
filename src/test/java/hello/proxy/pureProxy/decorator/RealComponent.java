package hello.proxy.pureProxy.decorator;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class RealComponent implements Component{

    @Override
    public String operation() {
        log.info("RealComponent.operation()");
        return "data";
    }
}
