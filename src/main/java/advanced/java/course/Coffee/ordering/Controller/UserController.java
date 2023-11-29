package advanced.java.course.Coffee.ordering.Controller;

import advanced.java.course.Coffee.ordering.Domain.Order;
import advanced.java.course.Coffee.ordering.Domain.User;
import advanced.java.course.Coffee.ordering.repository.UserRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "User")
@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {

    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    @GetMapping("/users/{user_id}/orders")
    public List<Order> getOrdersfromUser(@PathVariable("user_id") Integer user_id) {
        User user = userRepository.findById(user_id).orElseThrow(() -> new RuntimeException("User not found"));
        return user.getOrders();
    }
}
