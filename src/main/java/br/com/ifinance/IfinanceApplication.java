package br.com.ifinance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"br.com.ifinance.models"})
@EnableJpaRepositories("br.com.ifinance.repositories")
@ComponentScan("br.com.ifinance.services")
@ComponentScan("br.com.ifinance.controllers")
@ComponentScan("br.com.ifinance.resources")
@ComponentScan("br.com.ifinance.utils")
public class IfinanceApplication {

	public static void main(String[] args) {

		SpringApplication.run(IfinanceApplication.class, args);
	}

}
