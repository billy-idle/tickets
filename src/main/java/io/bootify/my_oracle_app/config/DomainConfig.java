package io.bootify.my_oracle_app.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EntityScan("io.bootify.my_oracle_app")
@EnableJpaRepositories("io.bootify.my_oracle_app")
@EnableTransactionManagement
public class DomainConfig {
}
