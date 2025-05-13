package org.piyush.Stackoverflow.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/question")
public class QuestionController {
    
    @PostMapping("add")
    public String addQuestion(@RequestBody String entity) {
        
        return entity;
    }

    @GetMapping("{questionId}")
    public String getQuestion(@RequestParam String entity) {
        
        return entity;
    }
    
}
