package org.piyush.Stackoverflow.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
import org.piyush.Stackoverflow.entity.Users;
import org.piyush.Stackoverflow.enums.UserStatus;
import org.piyush.Stackoverflow.repository.UsersRepository;
import org.piyush.Stackoverflow.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UserServiceImpl implements UserService{
    
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UsersRepository usersRepository;

    public UserSignUpResponse userSignUp(UserSignUpRequest user){
        logger.info("inside User sign up request");
        
        Users existingUser = usersRepository.findByUserNameOrEmail(user.getUserName(), user.getEmail());
        if(existingUser != null){
            throw new IllegalArgumentException("User Name or Email already exists.");
        }

        Users newUser = Users.builder().name(user.getName())
        .email(user.getEmail()).password(user.getPassword())
        .userName(user.getUserName()).isActive(UserStatus.ACTIVE)
        .isDeleted("N").build();   
        newUser = usersRepository.save(newUser);
        logger.info("User sign up successful");

        return new UserSignUpResponse(newUser.getUserName() + " signed up successfully.");
    } 

    public UserLoginResponse userLogin(UserLoginRequest userLoginRequest){
        logger.info("inside User login request");

        Users existingUser = usersRepository.findByUserNameOrEmail(userLoginRequest.userName(), userLoginRequest.email());
        if(existingUser == null){
            throw new IllegalArgumentException("UserName or Email not found. Please sign up first.");
        }

        Users user = usersRepository.findByEmailAndPassword(userLoginRequest.email(), userLoginRequest.password());
        if(user == null){
            throw new IllegalArgumentException("Invalid Password provided.");
        }

        return new UserLoginResponse(user.getUserName()+" logged in successfully.");
    } 

    public UserDataResponse getUserByUserName(String userName){
        logger.info("inside User get by id request");
        Users existingUser = usersRepository.findByUserName(userName);
        if(existingUser == null){
            throw new IllegalArgumentException("UserName not found.");
        }
        return new UserDataResponse(existingUser.getUserName(), existingUser.getEmail(), existingUser.getName());
    } 

    public List<UserDataResponse> getAllUsers(){
        logger.info("inside User get all request");
        List<Users> users = usersRepository.findAll();
        if(users.isEmpty()){
            throw new IllegalArgumentException("No users found.");
        }
        return users.stream()
            .map(user -> new UserDataResponse(user.getUserName(), user.getEmail(), user.getName()))
            .toList();
    } 

    public UserUpdateResponse updateUser(UserUpdateRequest user){
        logger.info("inside User update request");
        Users existingUser = usersRepository.findByUserNameOrEmail(user.userName(), user.email());
        if(existingUser == null){
            throw new IllegalArgumentException("UserName or Email not found. Please sign up first.");
        }

        existingUser.setName(user.name());
        existingUser.setUserName(user.userName());
        existingUser.setPassword(user.password());
        usersRepository.save(existingUser);
        logger.info("User updated successfully");
        return new UserUpdateResponse(existingUser.getUserName() + " updated successfully.");
    } 

    public UserDeleteResponse deleteUser(UserDeleteRequest user){
        logger.info("inside User delete request");
        Users existingUser = usersRepository.findByUserNameOrEmail(user.userName(), user.email());
        if(existingUser == null){
            throw new IllegalArgumentException("UserName or Email not found. Please sign up first.");
        }
        if(existingUser.getIsDeleted().equals("Y")){
            throw new IllegalArgumentException("User already deleted.");
        }
        existingUser.setIsDeleted("Y");
        usersRepository.save(existingUser);
        logger.info("User deleted successfully");
        
        return new UserDeleteResponse(existingUser.getUserName() + " deleted successfully.");
    }

}
