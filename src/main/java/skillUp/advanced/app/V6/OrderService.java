package skillUp.advanced.app.V6;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public void orderItem(String itemId) {
        log.info("orderService");
        orderRepository.save(itemId);
    }
}
