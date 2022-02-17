package skillUp.advanced.proxy.V1;

public class OrderRepositoryV1impl implements OrderRepositoryV1{

    public void save(String itemId) {
        if(itemId.equals("ex")) {
            throw new IllegalStateException("예외발생!");
        }
        sleep(1000);
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
