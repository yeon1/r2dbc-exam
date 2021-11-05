package exam.r2dbc.message;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface MessageRepository extends ReactiveCrudRepository<Message, MessageId>, MessageRepositoryCustom {
}
