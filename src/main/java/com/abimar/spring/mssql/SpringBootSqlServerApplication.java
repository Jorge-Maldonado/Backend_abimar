package com.abimar.spring.mssql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
    "com.abimar.spring.mssql",  // tu paquete principal
    "config"                    // agrega explícitamente el paquete donde está tu clase SwaggerStartupLogger
})
public class SpringBootSqlServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSqlServerApplication.class, args);
	}

}
