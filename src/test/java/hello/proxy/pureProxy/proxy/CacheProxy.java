package hello.proxy.pureProxy.proxy;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class CacheProxy implements Subject{

    private Subject target;
    private String cacheValue;

    public CacheProxy(Subject subject) {
        this.target = subject;
    }

    @Override
    public String operation() {
        log.info("CacheProxy.operation()");
        if(cacheValue == null){
            cacheValue = target.operation();
        }

        return cacheValue;
    }
}
