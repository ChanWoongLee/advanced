package skillUp.advanced;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import skillUp.advanced.trace.template.Callback;
import skillUp.advanced.trace.template.TimeLogTemplate;

@Slf4j
public class TemplateCallbackTest {

    @Test
    void callbackV1(){
        TimeLogTemplate template = new TimeLogTemplate();
        // 익명 내부 클래스
        template.execute(new Callback() {
            @Override
            public void call() {
                log.info("비지니스 로직 1 실행");
            }
        });
        // 템플릿 콜백 패턴 - 람다
        template.execute(() -> log.info("비지니스 로직 2 실행"));
    }

}
