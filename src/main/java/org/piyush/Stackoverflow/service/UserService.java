package org.piyush.Stackoverflow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import org.piyush.Stackoverflow.dto.UserLoginRequest;
import org.piyush.Stackoverflow.dto.UserSignUpRequest;
import org.piyush.Stackoverflow.entity.Users;
import org.piyush.Stackoverflow.enums.UserStatus;
import org.piyush.Stackoverflow.repository.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


// why to use interface ->  Migration to other system, full proof, contract 
@Service
public class UserService {
    
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UsersRepository usersRepository;

    public Users userSignUp(UserSignUpRequest user) throws Exception {
        logger.info("inside User sign up request");
        
        Users existingUser = usersRepository.findByUserNameOrEmail(user.getUserName(), user.getEmail());
        if(existingUser != null){
            throw new Exception("User Name or Email already exists.");
        }
        Users newUser = Users.builder().name(user.getName())
        .email(user.getEmail()).password(user.getPassword())
        .userName(user.getUserName()).isActive(UserStatus.ACTIVE)
        .isDeleted("N").build();   
        newUser = usersRepository.save(newUser);
        return newUser;
    } 

    public Users userLogin(UserLoginRequest userLoginRequest) throws Exception{
        logger.info("inside User login request");

        Users existingUser = usersRepository.findByUserNameOrEmail(userLoginRequest.getUserName(), userLoginRequest.getEmail());
        if(existingUser == null){
            throw new Exception("UserName or Email not found. Please sign up first.");
        }

        Users user = usersRepository.findByEmailAndPassword(userLoginRequest.getEmail(), userLoginRequest.getPassword());
        if(user == null){
            throw new Exception("Invalid Password provided.");
        }

        return user;
    } 

    public Users getUserByUserName(String userName) throws Exception{
        logger.info("inside User get by id request");
        Users existingUser = usersRepository.findByUserName(userName);
        if(existingUser == null){
            throw new Exception("UserName not found.");
        }
        return existingUser;
    } 

    public List<Users> getAllUsers(){
        logger.info("inside User get all request");
        return usersRepository.findAll();
    } 

    public Users updateUser(){
        logger.info("inside User update request");
        return null;
    } 

    public String deleteUser(Users user){
        logger.info("inside User delete request");
        user.setIsDeleted("Y");
        usersRepository.save(user);
        return "User deleted successfully.";
    } 

}
