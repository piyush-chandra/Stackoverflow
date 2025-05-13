package org.piyush.Stackoverflow.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/answer")
public class AnswerController {
    @PostMapping("add")
    public String addAnswer(@RequestBody String entity) {
        
        return entity;
    }

    @PostMapping("update")
    public String updateAnswer(@RequestBody String entity) {
        
        return entity;
    }

    @GetMapping("{answerId}")
    public String getAnswer(@RequestParam String entity) {
        
        return entity;
    }
    
}
