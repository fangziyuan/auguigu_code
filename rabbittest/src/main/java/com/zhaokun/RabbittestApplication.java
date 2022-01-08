package com.zhaokun;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class RabbittestApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbittestApplication.class, args);
	}

}
