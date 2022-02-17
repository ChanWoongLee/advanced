package skillUp.advanced.proxy.V1;

import lombok.RequiredArgsConstructor;

public class OrderServiceV1Impl implements OrderServiceV1{

    private  final OrderRepositoryV1 orderRepositoryV1;

    public OrderServiceV1Impl(OrderRepositoryV1 orderRepositoryV1){
        this.orderRepositoryV1 = orderRepositoryV1;
    }

    public void orderItem(String itemId){
        orderRepositoryV1.save(itemId);
    }

}
