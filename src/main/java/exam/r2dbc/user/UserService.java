package exam.r2dbc.user;

import lombok.RequiredArgsConstructor;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.data.relational.core.query.Criteria;
import org.springframework.data.relational.core.query.Query;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.data.relational.core.query.Query.*;
import static org.springframework.data.relational.core.query.Criteria.*;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository repository;
    private final R2dbcEntityTemplate template;
    private final DatabaseClient databaseClient;

    @Transactional
    public Mono<User> create(String email) {
        User user = User.builder().email(email).build();

        return repository.save(user);
    }

    public Mono<User> get(Long id) {
        return repository.findById(id);
    }

    public Flux<User> findByEmail(String email) {
        return template.select(query(where("email").is(email)), User.class);
    }
}
