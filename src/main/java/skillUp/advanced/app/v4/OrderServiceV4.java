package skillUp.advanced.app.v4;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import skillUp.advanced.trace.HelloTraceV1.HelloTraceV2;
import skillUp.advanced.trace.TraceId;
import skillUp.advanced.trace.TraceStatus;
import skillUp.advanced.trace.logTrace.LogTrace;
import skillUp.advanced.trace.template.AbstractTemplate;

@Service
@RequiredArgsConstructor
public class OrderServiceV4 {

    private final OrderRepositoryV4 orderRepository;
    private final LogTrace trace;

    public void orderItem(String itemId){

        AbstractTemplate<Void> abstractTemplate= new AbstractTemplate(trace) {
            @Override
            protected Void call() {
                orderRepository.save(itemId);
                return null;
            }
        };
        abstractTemplate.excute("OrderService.orderItem");
    }
}
