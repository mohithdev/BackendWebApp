package com.wipro.ProductInventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.wipro.ProductInventory.dao.UserRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class BackendWebAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendWebAppApplication.class, args);
	}

}
