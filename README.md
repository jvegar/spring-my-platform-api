# My Platform API

A modern Spring Boot API built with reactive programming support using Spring WebFlux and R2DBC.

## 🚀 Features

- Reactive programming with Spring WebFlux
- Reactive database access with R2DBC and PostgreSQL
- Database migration management with Flyway
- Lombok for reducing boilerplate code
- Comprehensive test support with Spring Boot Test and Reactor Test

## 📋 Prerequisites

- Java 17 or higher
- Maven 3.6 or higher
- PostgreSQL database

## 🛠️ Technology Stack

- Spring Boot 3.4.1
- Spring WebFlux
- Spring Data R2DBC
- PostgreSQL
- Flyway
- Lombok
- Maven

## 🏗️ Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/api/myplatform/
│   │       ├── config/
│   │       ├── controller/
│   │       ├── model/
│   │       ├── repository/
│   │       └── service/
│   └── resources/
│       ├── db/migration/
│       └── application.properties
└── test/
    └── java/
        └── com/api/myplatform/
```

## 🚀 Getting Started

1. Clone the repository:

```bash
git clone [your-repository-url]
```

2. Configure your database connection in `src/main/resources/application.properties`

3. Build the project:

```bash
mvn clean install
```

4. Run the application:

```bash
mvn spring-boot:run
```

## 🧪 Testing

Run the tests using:

```bash
mvn test
```

## 📦 Dependencies

- `spring-boot-starter-web`: Web application support
- `spring-boot-starter-webflux`: Reactive web support
- `spring-boot-starter-data-r2dbc`: Reactive database support
- `r2dbc-postgresql`: PostgreSQL R2DBC driver
- `flyway-core`: Database migration
- `lombok`: Reduces boilerplate code
- `spring-boot-starter-test`: Testing support
- `reactor-test`: Reactive testing support

## 🔧 Configuration

The application uses Flyway for database migrations. Configuration can be found in:

- `src/main/resources/flyway.conf`
- `src/main/resources/application.properties`
