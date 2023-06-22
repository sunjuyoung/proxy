package hello.proxy.app.config.v1_proxy.concrete_proxy;

import hello.proxy.app.v2.OrderControllerV2;
import hello.proxy.app.v2.OrderServiceV2;
import hello.proxy.trace.TraceStatus;
import hello.proxy.trace.logtrace.LogTrace;

public class OrderControllerConcreteProxy extends OrderControllerV2 {

    private OrderControllerV2 target;
    private LogTrace logTrace;


    public OrderControllerConcreteProxy(  OrderControllerV2 target, LogTrace logTrace) {
        super(null);
        this.target = target;
        this.logTrace = logTrace;
    }

    @Override
    public String request(String itemId) {
        TraceStatus status = null;

        try {
            status = logTrace.begin("OrderController");
            String request = target.request(itemId);
            logTrace.end(status);
            return request;
        }catch (Exception e){

            logTrace.exception(status,e);
            throw  e;
        }


    }

    @Override
    public String noLog() {
        return super.noLog();
    }
}
