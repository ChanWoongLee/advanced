package skillUp.advanced.concreteProxy;

import org.junit.jupiter.api.Test;

public class ConcreteProxyTest {
    @Test
    void noProxy() {
        ConcreteLogic concreteLogic = new ConcreteLogic();
        ConcreteClient client = new ConcreteClient(concreteLogic);
        client.execute();
    }
}
