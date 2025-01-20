package com.api.my_platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class MyPlatformApplication {

	private static final Logger logger = LoggerFactory.getLogger(MyPlatformApplication.class);

	public static void main(String[] args) {

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
