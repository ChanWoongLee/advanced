package skillUp.advanced.proxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CacheProxy implements Subject {
    private Subject subject;
    private String cacheValue;

    public CacheProxy(Subject target) {
        this.subject = target;
    }
    public String operation(){
        log.info("프록시호출");
        if (cacheValue == null) {
            cacheValue = subject.operation();
        }
        return cacheValue;
    }
}
