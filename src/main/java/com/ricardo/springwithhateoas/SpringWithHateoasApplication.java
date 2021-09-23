package com.ricardo.springwithhateoas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@ComponentScan("com.ricardo.springwithhateoas.repositories")
public class SpringWithHateoasApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWithHateoasApplication.class, args);
	}

}
