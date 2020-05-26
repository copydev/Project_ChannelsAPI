package com.example.sampleproject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SampleProjectApplication {

    private static Logger logger = LogManager.getLogger(SampleProjectApplication.class);

    public static void main(String[] args) {

        logger.info("Getting started the spring boot application.");
        logger.warn("Warning !!");
        logger.error("Error !!");
        logger.debug("Debug !!");
        logger.fatal("Fatal !!");

        SpringApplication.run(SampleProjectApplication.class, args);
    }

}
