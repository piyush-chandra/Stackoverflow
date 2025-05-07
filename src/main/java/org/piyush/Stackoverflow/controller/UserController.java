package org.piyush.Stackoverflow.controller;

import java.util.List;

import org.piyush.Stackoverflow.dto.UserLoginRequest;
import org.piyush.Stackoverflow.entity.Users;
import org.piyush.Stackoverflow.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/UserService")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;
    
    @PostMapping("/signUp")
    private Users userSignUp(@RequestBody Users  user){
        logger.info("inside User sign up request");
        return userService.userSignUp(user);
    } 

    @PostMapping("/login")
    private Users userLogin(@RequestBody UserLoginRequest userLoginRequest){
        logger.info("inside User login request");
        return userService.userLogin(userLoginRequest);
    } 

    @GetMapping("User/{userId}")
    private Users getUserById(@PathVariable Long userId){
        logger.info("inside User get by id request");
        return userService.getUserById(userId);
    } 

    @GetMapping("User")
    private List<Users> getAllUsers(){
        logger.info("inside User get all request");
        return userService.getAllUsers();
    } 

    @PostMapping("/update")
    private Users updateUser(){
        logger.info("inside User update request");
        return null;
    } 

    @PostMapping("deleteUser")
    private String deleteUser(@RequestBody Users user){
        logger.info("inside User delete request");
        return userService.deleteUser(user);
    } 
}
