package com.brcubg.demoSpringProject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoSpringProjectApplication {

    private static final Logger logger = LoggerFactory.getLogger(DemoSpringProjectApplication.class);
    public static void main(String[] args) {
        logger.info("CRUD operation with repository!!");
		SpringApplication.run(DemoSpringProjectApplication.class, args);
    }

}
