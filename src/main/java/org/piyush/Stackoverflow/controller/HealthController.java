package org.piyush.Stackoverflow.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {
	private static final Logger logger = LoggerFactory.getLogger(HealthController.class);

    @GetMapping("/healthCheck")
    public String health() {
        logger.info("Inside UserController :: finally logging is working now.");
        return "UserService is running";
    }
}
