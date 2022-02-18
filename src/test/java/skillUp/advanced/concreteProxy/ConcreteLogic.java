package skillUp.advanced.concreteProxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public  class ConcreteLogic {
    public String operation() {
        log.info("콘크리토 로직 실행");
        return "data";
    }
}
