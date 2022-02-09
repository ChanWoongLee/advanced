package skillUp.advanced.app.v1;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import skillUp.advanced.trace.HelloTraceV1.HelloTraceV1;
import skillUp.advanced.trace.TraceStatus;

@RestController
@RequiredArgsConstructor
public class OrderControllerV1 {

    private final OrderServiceV1 orderService;
    private final HelloTraceV1 trace;
    
    @GetMapping("/v1/request")
    public String request(String itemId){
        TraceStatus status trace.begin("OrderController.request()");
        orderService.orderItem(itemId);

        return "OK";
    }
}
