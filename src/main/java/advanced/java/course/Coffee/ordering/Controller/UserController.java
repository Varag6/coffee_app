package advanced.java.course.Coffee.ordering.Controller;

import advanced.java.course.Coffee.ordering.repository.UserRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "User")
@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {

    private UserRepository userRepository;


}
