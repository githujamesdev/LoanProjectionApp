package com.jia.co.ke.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = GsonAutoConfiguration.class)
@ComponentScan(basePackages = "com.jia.co.ke.main")
@EnableJpaRepositories(basePackages = "com.jia.co.ke.main.repository")
@EntityScan(basePackages = "com.jia.co.ke.main.models")
public class LoanProjectionApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(LoanProjectionApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(LoanProjectionApplication.class, args);
    }

}
