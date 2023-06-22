package hello.proxy.app.config.v1_proxy.concrete_proxy;

import hello.proxy.app.v2.OrderRepositoryV2;
import hello.proxy.trace.TraceStatus;
import hello.proxy.trace.logtrace.LogTrace;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class OrderRepositoryConcreteProxy extends OrderRepositoryV2 {

    private LogTrace logTrace;
    private OrderRepositoryV2 target;


    public OrderRepositoryConcreteProxy(LogTrace logTrace, OrderRepositoryV2 target) {
        this.logTrace = logTrace;
        this.target = target;
    }

    @Override
    public void save(String itemId) {
        TraceStatus status = null;

        try {
            status = logTrace.begin("OrderRepository");
            target.save(itemId);
            logTrace.end(status);
        }catch (Exception e){
            logTrace.exception(status,e);
        }
    }
}
