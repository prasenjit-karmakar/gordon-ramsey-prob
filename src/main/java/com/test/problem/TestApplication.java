package com.test.problem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication
@EnableAutoConfiguration
public class TestApplication extends SpringBootServletInitializer {
    public static void main(String[] args)  {
        SpringApplication.run(TestApplication.class, args);
    }
}
