package org.piyush.Stackoverflow.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @PostMapping("add")
    public String addComment(@RequestBody String entity) {
        
        return entity;
    }
}
