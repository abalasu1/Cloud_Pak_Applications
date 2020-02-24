package com.quotemachine.quoteapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class QuoteapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuoteapiApplication.class, args);
	}

}
