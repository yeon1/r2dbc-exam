package exam.r2dbc.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class FlywayConfig {

    private final Environment env;

    @Bean(initMethod = "migrate")
    public Flyway flyway() {
        return new Flyway(Flyway.configure().baselineOnMigrate(false).dataSource(
                env.getRequiredProperty("spring.flyway.url"),
                env.getRequiredProperty("spring.flyway.user"),
                env.getRequiredProperty("spring.flyway.password")
        ));
    }
}
