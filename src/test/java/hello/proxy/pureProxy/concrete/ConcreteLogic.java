package hello.proxy.pureProxy.concrete;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class ConcreteLogic {

    public String operation(){
        log.info("operation");
        return "data";
    }
}

