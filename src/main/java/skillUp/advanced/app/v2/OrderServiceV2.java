package skillUp.advanced.app.v2;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import skillUp.advanced.trace.HelloTraceV1.HelloTraceV1;
import skillUp.advanced.trace.HelloTraceV1.HelloTraceV2;
import skillUp.advanced.trace.TraceId;
import skillUp.advanced.trace.TraceStatus;

@Service
@RequiredArgsConstructor
public class OrderServiceV2 {

    private final OrderRepositoryV2 orderRepository;
    private final HelloTraceV2 trace;

    public void orderItem(TraceId traceId, String itemId){
        TraceStatus status = null;
        try {
            status = trace.beginSync(traceId,"OrderServiceV1.request()");
            orderRepository.save(itemId);
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }

    }
}
