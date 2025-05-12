package org.piyush.Stackoverflow.controller;

import java.util.List;

import org.piyush.Stackoverflow.dto.UserDataResponse;
import org.piyush.Stackoverflow.dto.UserDeleteRequest;
import org.piyush.Stackoverflow.dto.UserDeleteResponse;
import org.piyush.Stackoverflow.dto.UserLoginRequest;
import org.piyush.Stackoverflow.dto.UserLoginResponse;
import org.piyush.Stackoverflow.dto.UserSignUpRequest;
import org.piyush.Stackoverflow.dto.UserSignUpResponse;
import org.piyush.Stackoverflow.dto.UserUpdateRequest;
import org.piyush.Stackoverflow.dto.UserUpdateResponse;
import org.piyush.Stackoverflow.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;
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
    private ResponseEntity<?> userSignUp(@RequestBody UserSignUpRequest  userRequest){
        logger.info("inside User sign up request");
        UserSignUpResponse user = userService.userSignUp(userRequest);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    } 

    @PostMapping("/login")
    private ResponseEntity<?> userLogin(@RequestBody UserLoginRequest userLoginRequest){
        logger.info("inside User login request");
        UserLoginResponse user = userService.userLogin(userLoginRequest);
        return new ResponseEntity<>(user, HttpStatus.OK);
    } 

    @GetMapping("user/{userName}")
    private ResponseEntity<?> getUserById(@PathVariable String userName){
        logger.info("inside User get by id request");
        UserDataResponse user = userService.getUserByUserName(userName);
        return new ResponseEntity<>(user, HttpStatus.OK);
    } 

    @GetMapping("user")
    private List<UserDataResponse> getAllUsers(){
        logger.info("inside User get all request");
        return userService.getAllUsers();
    } 

    @PostMapping("update")
    private UserUpdateResponse updateUser(@RequestBody UserUpdateRequest user){
        logger.info("inside User update request");
        return userService.updateUser(user);
    } 

    @PostMapping("deleteUser")
    private UserDeleteResponse deleteUser(@RequestBody UserDeleteRequest user){
        logger.info("inside User delete request");
        return userService.deleteUser(user);
    } 
}
