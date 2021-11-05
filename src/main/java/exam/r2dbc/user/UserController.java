package exam.r2dbc.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @GetMapping("users")
    public Mono<String> test() {
        return userService.create("aaaaa@aaaa.aaa").map(User::getEmail);
    }


}
