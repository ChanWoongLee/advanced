import org.junit.jupiter.api.Test;
import skillUp.advanced.trace.TraceStatus;
import skillUp.advanced.trace.logTrace.FieldLogTrace;

import static org.junit.jupiter.api.Assertions.*;

public class FieldLogTraceTest {

    FieldLogTrace trace = new FieldLogTrace();

    @Test
    void begin_end_level12(){
        TraceStatus status1 = trace.begin("hello1");
        TraceStatus status2 = trace.begin("hello2");
        trace.end(status2);
        trace.end(status1);
    }
}