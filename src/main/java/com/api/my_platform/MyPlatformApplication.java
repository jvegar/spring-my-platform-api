package com.api.my_platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MyPlatformApplication {

	public static void main(String[] args) {
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
