package skillUp.advanced.proxy.V1;

public class OrderControllerV1Impl implements OrderControllerV1 {
    private final OrderServiceV1 orderServiceV1;

    public OrderControllerV1Impl(OrderServiceV1 orderServiceV1){
        this.orderServiceV1 = orderServiceV1;
    }

    @Override
    public String request(String itemId) {
        orderServiceV1.orderItem(itemId);
        return "OK";
    }

    @Override
    public String noLog() {
        return "noLog";
    }
}
