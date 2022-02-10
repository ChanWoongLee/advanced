package skillUp.advanced.app.v4;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import skillUp.advanced.trace.HelloTraceV1.HelloTraceV2;
import skillUp.advanced.trace.TraceStatus;
import skillUp.advanced.trace.logTrace.LogTrace;
import skillUp.advanced.trace.template.AbstractTemplate;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV4 {
    private final LogTrace trace;

    public void save(String itemId) {

        AbstractTemplate<Void> abstractTemplate= new AbstractTemplate(trace) {
            @Override
            protected Void call() {
                if(itemId.equals("ex")) {
                    throw new IllegalStateException("예외발생!");
                } sleep(1000);
                return null;
            }
        };
        abstractTemplate.excute("OrderRepository.save");

    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
