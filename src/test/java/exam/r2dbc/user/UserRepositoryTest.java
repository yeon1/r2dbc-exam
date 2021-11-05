package exam.r2dbc.user;

import exam.r2dbc.config.R2dbcConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@Slf4j
@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = R2dbcConfig.class)
@DataR2dbcTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void insertTest() {
        User user = User.builder().id(2L).email("abc@email.com").build();

        Mono<User> userMono = userRepository.save(user);

        assertEquals(userMono.block().getId(), 2L);
    }
}
