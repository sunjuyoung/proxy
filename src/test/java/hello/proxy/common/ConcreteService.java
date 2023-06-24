package hello.proxy.common;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class ConcreteService {

    public void call(){
        log.info("Concrete CAll");
    }
}
