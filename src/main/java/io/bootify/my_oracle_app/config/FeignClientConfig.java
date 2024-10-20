package io.bootify.my_oracle_app.config;

import feign.Retryer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientConfig {

    @Bean
    public Retryer retryer() {
        return new Retryer.Default(500, 1000, 3);
    }
}
