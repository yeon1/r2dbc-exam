package exam.r2dbc.config;

import io.r2dbc.spi.ConnectionFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.r2dbc.connection.R2dbcTransactionManager;
import org.springframework.transaction.ReactiveTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@RequiredArgsConstructor
@EnableTransactionManagement
@Configuration
public class R2dbcConfig extends AbstractR2dbcConfiguration {
    private final ConnectionFactory connectionFactory;

    @Override
    public ConnectionFactory connectionFactory() {
        return connectionFactory;
    }

    @Bean
    public ReactiveTransactionManager transactionManager() {
        return new R2dbcTransactionManager(connectionFactory);
    }
}
