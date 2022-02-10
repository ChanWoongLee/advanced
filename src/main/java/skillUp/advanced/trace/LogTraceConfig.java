package skillUp.advanced.trace;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import skillUp.advanced.trace.logTrace.FieldLogTrace;
import skillUp.advanced.trace.logTrace.LogTrace;

@Configuration
public class LogTraceConfig {

    @Bean
    public LogTrace logTrace(){
        return new FieldLogTrace();
    }
}
