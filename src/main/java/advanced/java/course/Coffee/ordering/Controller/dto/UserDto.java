package advanced.java.course.Coffee.ordering.Controller.dto;

import advanced.java.course.Coffee.ordering.Domain.Order;
import advanced.java.course.Coffee.ordering.Domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

        private Integer user_id;
        private String username;
        private String password;
        private String role;
        private List<OrderDto> orders;

        public static UserDto fromUser(User user) {
            return new UserDto(
                    user.getUser_id(),
                    user.getUsername(),
                    user.getPassword(),
                    user.getRole(),
                    OrderDto.fromOrder(user.getOrders())
            );
        }
}
