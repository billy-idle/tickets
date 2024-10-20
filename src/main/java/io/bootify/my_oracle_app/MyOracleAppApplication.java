package io.bootify.my_oracle_app;

import io.bootify.my_oracle_app.indisponibilidad.IndisponibilidadService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;


@EnableFeignClients
@SpringBootApplication
public class MyOracleAppApplication {

    public static void main(final String[] args) {
        SpringApplication.run(MyOracleAppApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(final IndisponibilidadService indisponibilidadService) {
        return args -> {
            indisponibilidadService.reportar();
        };
    }

}
