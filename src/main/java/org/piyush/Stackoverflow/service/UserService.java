package org.piyush.Stackoverflow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import org.piyush.Stackoverflow.dto.UserLoginRequest;
import org.piyush.Stackoverflow.entity.Users;
import org.piyush.Stackoverflow.repository.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UserService {
    
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UsersRepository usersRepository;

    public Users userSignUp(Users user){
        logger.info("inside User sign up request");
        user = usersRepository.save(user);
        return user;
    } 

    public Users userLogin(UserLoginRequest userLoginRequest){
        logger.info("inside User login request");
        Users user = usersRepository.findByEmailAndPassword(userLoginRequest.getEmail(), userLoginRequest.getPassword());
        return user;
    } 

    public Users getUserById(Long userId){
        logger.info("inside User get by id request");
        return usersRepository.findByUserId(userId);
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
