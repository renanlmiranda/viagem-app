package com.rennes.viagem_app;

import com.rennes.viagem_app.config.EnvironmentConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ViagemAppApplication {

	public static void main(String[] args) {
		try {
			ApplicationContext context = SpringApplication.run(ViagemAppApplication.class, args);
			EnvironmentConfig envConfig = context.getBean(EnvironmentConfig.class);
			System.out.println("Database connected: " + envConfig.getDbName());
		} catch (Exception e) {
			System.err.println("Error starting application: " + e.getMessage());
			e.printStackTrace();
		}
	}

}
