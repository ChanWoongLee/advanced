package skillUp.advanced.trace.template;

import skillUp.advanced.trace.TraceStatus;
import skillUp.advanced.trace.logTrace.LogTrace;

public abstract class AbstractTemplate<T> {
    private final LogTrace trace;

    public AbstractTemplate(LogTrace trace) {
        this.trace = trace;
    }

    public T excute(String message) {
        TraceStatus status = null;
        try {
            status = trace.begin(message);
            // 로직호출
            T result = call();
            trace.end(status);
            return result;
        } catch (Exception e) {
            trace.exception(status, e);
            throw  e;
        }

    }
    protected abstract T call();
}
