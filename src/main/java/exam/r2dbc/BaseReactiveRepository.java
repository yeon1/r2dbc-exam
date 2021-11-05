package exam.r2dbc;

import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.data.relational.core.query.Query;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class BaseReactiveRepository<T> {
    private final R2dbcEntityTemplate template;
    private final Class<T> type;

    public BaseReactiveRepository(R2dbcEntityTemplate template, Class<T> type) {
        this.template = template;
        this.type = type;
    }

    public Flux<T> select(Query query) {
        return template.select(query, type);
    }
}
