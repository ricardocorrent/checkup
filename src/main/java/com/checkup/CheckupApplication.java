package com.checkup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSpringDataWebSupport
@EnableAutoConfiguration
@EnableSwagger2
public class CheckupApplication {

    public static void main(String[] args) {
        SpringApplication.run(CheckupApplication.class, args);
    }

}
