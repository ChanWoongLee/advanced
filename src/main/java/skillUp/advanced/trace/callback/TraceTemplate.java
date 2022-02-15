package skillUp.advanced.trace.callback;

import skillUp.advanced.trace.TraceStatus;
import skillUp.advanced.trace.logTrace.LogTrace;

public class TraceTemplate {
    private final LogTrace trace;

    public TraceTemplate(LogTrace trace){
        this.trace = trace;
    }

    public <T> T excute(String message, TraceCallback<T> callback){
        TraceStatus status = null;
        try {
            T result = callback.call();

            trace.end(status);
            return result;
        } catch (Exception e) {
            trace.exception(status,e);
            throw e;
        }
    }
}
