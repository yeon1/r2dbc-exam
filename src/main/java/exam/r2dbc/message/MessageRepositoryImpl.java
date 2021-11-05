package exam.r2dbc.message;

import exam.r2dbc.BaseReactiveRepository;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;

public class MessageRepositoryImpl extends BaseReactiveRepository<Message> implements MessageRepositoryCustom {

    public MessageRepositoryImpl(R2dbcEntityTemplate template) {
        super(template, Message.class);
    }

}
