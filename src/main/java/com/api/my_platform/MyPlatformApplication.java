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
		logger.info("Running MyPlatform application ...");
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
