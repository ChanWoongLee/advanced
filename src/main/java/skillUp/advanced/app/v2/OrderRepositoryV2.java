package skillUp.advanced.app.v2;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import skillUp.advanced.trace.HelloTraceV1.HelloTraceV1;
import skillUp.advanced.trace.HelloTraceV1.HelloTraceV2;
import skillUp.advanced.trace.TraceStatus;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV2 {
    private final HelloTraceV2 trace;

    public void save(String itemId) {
        TraceStatus status = null;
        try {
            status = trace.begin("OrderRepositoryV1.request()");
            if(itemId.equals("ex")) {
                throw new IllegalStateException("예외발생!");
            }
            sleep(1000);
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }

    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
