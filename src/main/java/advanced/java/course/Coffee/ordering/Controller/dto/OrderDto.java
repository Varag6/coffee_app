package advanced.java.course.Coffee.ordering.Controller.dto;

import advanced.java.course.Coffee.ordering.Domain.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    private Integer order_id;
    private String name;

    public static List<OrderDto> fromOrder(List<Order> orders) {
        return orders.stream()
                .map(order -> new OrderDto(
                        // map fields from order to OrderDto
                ))
                .collect(Collectors.toList());
    }
}
