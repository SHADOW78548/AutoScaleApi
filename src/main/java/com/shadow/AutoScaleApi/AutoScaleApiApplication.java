package com.shadow.AutoScaleApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
@OpenAPIDefinition(
		    info = @io.swagger.v3.oas.annotations.info.Info(
        title = "AutoScaleApi",
        version = "1.0",
        description = "API documentation for AutoScaleApi application",
        contact = @io.swagger.v3.oas.annotations.info.Contact(
            name = "Sujit Mondal",
            email = "sujit.mondal2@cognizant.com",
            url = "https://shadow78548.github.io/My_Portfolio/"
            )
        )
		    )
@SpringBootApplication
public class AutoScaleApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(AutoScaleApiApplication.class, args);
	}

}
