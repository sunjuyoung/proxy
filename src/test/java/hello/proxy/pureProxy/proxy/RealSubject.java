package hello.proxy.pureProxy.proxy;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class RealSubject implements Subject{

    @Override
    public String operation() {
        log.info("RealSubject.operation()");
        sleep(1000);
        return "data";
    }

    private void sleep(int mill) {
        try {
            Thread.sleep(mill);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
