package hello.proxy.jdkDynamic;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class AImpl implements AInterface{

    @Override
    public String call() {
        log.info("AImpl call");
        return "A";
    }
}
