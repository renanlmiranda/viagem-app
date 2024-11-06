package com.rennes.viagem_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.rennes.viagem_app.repository")
@EnableConfigurationProperties
public class ViagemAppApplication {

	public static void main(String[] args) {
		try {
			ApplicationContext context = SpringApplication.run(ViagemAppApplication.class, args);
		} catch (Exception e) {
			System.err.println("Error starting application: " + e.getMessage());
			e.printStackTrace();
		}
	}

}
