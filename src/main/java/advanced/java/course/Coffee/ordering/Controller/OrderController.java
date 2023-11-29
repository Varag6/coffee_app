package advanced.java.course.Coffee.ordering.Controller;

import advanced.java.course.Coffee.ordering.Controller.dto.CategoryDto;
import advanced.java.course.Coffee.ordering.Controller.dto.OrderDto;
import advanced.java.course.Coffee.ordering.Domain.Category;
import advanced.java.course.Coffee.ordering.Domain.Order;
import advanced.java.course.Coffee.ordering.repository.OrderRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Tag(name = "Order")
@RequestMapping("/orders")
@Slf4j
@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderRepository orderRepository;


    @GetMapping(value = "/{order_id}")
    public Order getOrder(@PathVariable("order_id") Integer order_id) {
        return orderRepository.findById(order_id).get();
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderRepository.save(order);
    }
}
