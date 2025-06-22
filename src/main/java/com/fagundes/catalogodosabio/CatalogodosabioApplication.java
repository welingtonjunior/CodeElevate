package com.fagundes.catalogodosabio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CatalogodosabioApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalogodosabioApplication.class, args);
	}

}
