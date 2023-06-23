package hello.proxy.jdkDynamic;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class BImpl implements BInterface{

    @Override
    public String call() {
        log.info("BImpl call");
        return "B";
    }
}
