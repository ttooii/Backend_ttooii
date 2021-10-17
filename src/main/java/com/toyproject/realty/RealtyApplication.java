package com.toyproject.realty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class RealtyApplication {

    public static void main(String[] args) {
        SpringApplication.run(RealtyApplication.class, args);
    }

}
