
package skillUp.advanced.app.V5;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import skillUp.advanced.app.v4.OrderServiceV4;
import skillUp.advanced.trace.logTrace.LogTrace;
import skillUp.advanced.trace.template.AbstractTemplate;

@RestController
@RequiredArgsConstructor
public class OrderControllerV5 {

    private final OrderServiceV4 orderService;
    private final LogTrace trace;

    @GetMapping("/v5/request")
    public String request(String itemId){
        AbstractTemplate<String> abstractTemplate= new AbstractTemplate(trace) {
            @Override
            protected String call() {
                orderService.orderItem(itemId);
                return "ok";
            }
        };
        return abstractTemplate.excute("hello");
    }
}
