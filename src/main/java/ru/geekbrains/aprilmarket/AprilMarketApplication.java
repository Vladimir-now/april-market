package ru.geekbrains.aprilmarket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@PropertySource("private.properties")
@SpringBootApplication
public class AprilMarketApplication {

	public static void main(String[] args) {
		SpringApplication.run(AprilMarketApplication.class, args);
	}

}
