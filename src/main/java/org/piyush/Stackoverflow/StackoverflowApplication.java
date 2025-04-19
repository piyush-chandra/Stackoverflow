package org.piyush.Stackoverflow;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class StackoverflowApplication {

	private static final Logger logger = LoggerFactory.getLogger(StackoverflowApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(StackoverflowApplication.class, args);
		logger.info("Application started successfully");
	}
}
