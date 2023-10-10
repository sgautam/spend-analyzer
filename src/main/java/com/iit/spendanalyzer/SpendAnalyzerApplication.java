package com.iit.spendanalyzer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@SpringBootApplication
@EnableJpaRepositories("com.iit.spendanalyzer.persistence.repo") 
@EntityScan("com.iit.spendanalyzer.persistence.model")
@EnableWebSecurity
public class SpendAnalyzerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpendAnalyzerApplication.class, args);
	}

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                                .anyRequest().permitAll()
                ).csrf(csrf -> csrf.disable());
		return http.build();
    }
}
