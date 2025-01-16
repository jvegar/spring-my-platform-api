package com.api.my_platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;

import io.github.cdimascio.dotenv.Dotenv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class MyPlatformApplication {

	private static final Logger logger = LoggerFactory.getLogger(MyPlatformApplication.class);

	public static void main(String[] args) {
		// Load the .env file
		Dotenv dotenv = Dotenv.load();

		// Set system properties from .env
		System.setProperty("R2DBC_URL", dotenv.get("R2DBC_URL"));
		System.setProperty("R2DBC_USERNAME", dotenv.get("R2DBC_USERNAME"));
		System.setProperty("R2DBC_PASSWORD", dotenv.get("R2DBC_PASSWORD"));

		// Log the environment variables
		logger.info("R2DBC URL: {}", System.getProperty("R2DBC_URL"));
		logger.info("R2DBC Username: {}", System.getProperty("R2DBC_USERNAME"));
		// Be cautious about logging sensitive information like passwords
		logger.info("R2DBC Password: {}", System.getProperty("R2DBC_PASSWORD").replaceAll(".", "*")); // Mask the
																										// password

		if (System.getProperty("R2DBC_URL") == null || System.getProperty("R2DBC_URL").isEmpty()) {
			logger.error("R2DBC_URL is not set!");
		}

		if (System.getProperty("R2DBC_USERNAME") == null || System.getProperty("R2DBC_USERNAME").isEmpty()) {
			logger.error("R2DBC_USERNAME is not set!");
		}

		if (System.getProperty("R2DBC_PASSWORD") == null || System.getProperty("R2DBC_PASSWORD").isEmpty()) {
			logger.error("R2DBC_PASSWORD is not set!");
		}

		SpringApplication.run(MyPlatformApplication.class, args);
	}

	@Bean
	public FlywayMigrationStrategy flywayMigrationStrategy() {
		return flyway -> {
			// This will clean the database before running migrations
			// Be careful with this in production!
			// flyway.clean();
			flyway.migrate();
		};
	}

}
