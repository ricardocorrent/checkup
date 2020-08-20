package com.checkup;

import com.checkup.image.DocumentStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableAutoConfiguration
@EnableConfigurationProperties(DocumentStorageProperties.class)
public class CheckupApplication {

	public static void main(String[] args) {
		SpringApplication.run(CheckupApplication.class, args);
	}

}
