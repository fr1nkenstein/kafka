package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
@EnableKafka
public class VishwakarKafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(VishwakarKafkaApplication.class, args);
	}

}
