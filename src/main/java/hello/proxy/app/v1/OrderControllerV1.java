package hello.proxy.app.v1;

import hello.proxy.app.v2.OrderServiceV2;
import hello.proxy.trace.logtrace.LogTrace;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Log4j2
@RequestMapping
@ResponseBody
public class OrderControllerV1 {

    private  OrderServiceV1 orderService;



    public OrderControllerV1(OrderServiceV1 orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/v1/request")
    public String request(String itemId){
        orderService.orderItem(itemId);
        return "ok";
    }

    @GetMapping("/v1/noLog")
    public String noLog(){
        return "null";
    }

}
