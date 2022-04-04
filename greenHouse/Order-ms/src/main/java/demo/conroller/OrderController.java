package demo.conroller;

import demo.entity.Order;
import demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {

    @Autowired
    private
    OrderRepository orderRepository;

    @GetMapping("/orders")
    public List<Order> orderAll(@RequestParam(value = "name", defaultValue = "GreenHouse") String name) {
        return orderRepository.findAll();
    }

    @GetMapping("orders/{orderId}")
    public Order productById(@PathVariable Long orderId){
        Optional<Order> order =  orderRepository.findById(orderId);
        return order.orElse(null);
    }

    @GetMapping("ordersbycustomer/{customerId}")
    public List<Order> productByCustomerId(@PathVariable Long customerId){
        return orderRepository.findByCustomerId(customerId);
    }


}
