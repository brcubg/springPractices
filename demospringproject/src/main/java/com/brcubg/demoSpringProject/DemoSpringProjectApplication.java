package com.brcubg.demoSpringProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoSpringProjectApplication {

    public static void main(String[] args) {
		System.out.println("CRUD operation with repository");
		SpringApplication.run(DemoSpringProjectApplication.class, args);
    }

}
