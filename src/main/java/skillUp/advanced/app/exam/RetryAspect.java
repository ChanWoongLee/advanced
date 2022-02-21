package skillUp.advanced.app.exam;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;

@Slf4j
@Aspect
public class RetryAspect {
    @Around("@annotation(skillUp.advanced.app.exam.Trace)")
    public Object doRetry(ProceedingJoinPoint joinPoint, Retry retry) throws Throwable{
        log.info("[retry {} retry = {}]",joinPoint.getSignature(), retry);
        Exception exceptionHolder = null;

        int maxRetry = retry.value();
        for (int retryCount = 1; retryCount < maxRetry; retryCount++) {
            try {
                log.info("[retry] try count = {}/{}",retryCount,maxRetry);
                return joinPoint.proceed();
            } catch (Exception e) {
                exceptionHolder = e;
            }
        }
        throw  exceptionHolder;
    }
}
