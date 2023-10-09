package com.iit.spendanalyzer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.iit.spendanalyzer.persistence.repo") 
@EntityScan("com.iit.spendanalyzer.persistence.model")
public class SpendAnalyzerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpendAnalyzerApplication.class, args);
	}

}
