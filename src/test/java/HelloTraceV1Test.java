import org.junit.jupiter.api.Test;
import skillUp.advanced.trace.HelloTraceV1.HelloTraceV1;
import skillUp.advanced.trace.HelloTraceV1.HelloTraceV2;
import skillUp.advanced.trace.TraceStatus;

public class HelloTraceV1Test {
    @Test
    void begin_end() {
        HelloTraceV2 trace = new HelloTraceV2();
        TraceStatus stats1 = trace.begin("hello");
        TraceStatus stats2 = trace.beginSync(stats1.getTraceId(), "hello");
        trace.end(stats2);
        trace.end(stats1);
    }

    @Test
    void begin_exception() {
        HelloTraceV1 trace = new HelloTraceV1();
        TraceStatus status = trace.begin("hello");
        trace.exception(status, new IllegalStateException());
    }
}


