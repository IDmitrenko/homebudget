package ru.dias.homebudget;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class HomebudgetApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomebudgetApplication.class, args);
	}

}
