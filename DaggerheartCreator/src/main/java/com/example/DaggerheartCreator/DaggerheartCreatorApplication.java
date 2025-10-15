package com.example.DaggerheartCreator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class DaggerheartCreatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(DaggerheartCreatorApplication.class, args);
	}

}
