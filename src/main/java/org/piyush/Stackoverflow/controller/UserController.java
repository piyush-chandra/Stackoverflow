package org.piyush.Stackoverflow.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    
    @GetMapping("/healthCheck")
    public String health() {
        return "UserService is up and running";
    }


}
