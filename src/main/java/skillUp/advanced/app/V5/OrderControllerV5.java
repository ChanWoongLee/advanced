
package skillUp.advanced.app.V5;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import skillUp.advanced.app.v4.OrderServiceV4;
import skillUp.advanced.trace.callback.TraceCallback;
import skillUp.advanced.trace.callback.TraceTemplate;
import skillUp.advanced.trace.logTrace.LogTrace;
import skillUp.advanced.trace.template.AbstractTemplate;

@RestController
public class OrderControllerV5 {

    private final OrderServiceV4 orderService;
    private final TraceTemplate template;

    public OrderControllerV5(OrderServiceV4 orderService,LogTrace trace) {
        this.orderService = orderService;
        this.template = new TraceTemplate(trace);
    }


    @GetMapping("/v5/request")
    public String request(String itemId){
        return template.excute("OrderController request()", new TraceCallback<>() {
            @Override
            public String call() {
                orderService.orderItem(itemId);

                return "ok";
            }
        });
    }
}
