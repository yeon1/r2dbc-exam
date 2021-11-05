package exam.r2dbc.user;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void createUserTest() {
        Mono<User> userMono = userService.create("tester@email.com");

        StepVerifier.create(userMono)
                .assertNext(u -> assertEquals(u.getEmail(), "tester@email.com"))
                .verifyComplete();
    }

}
