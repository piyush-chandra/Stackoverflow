package org.piyush.Stackoverflow.service;

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

public interface UserService {
    public UserSignUpResponse userSignUp(UserSignUpRequest user);
    public UserLoginResponse userLogin(UserLoginRequest userLoginRequest);
    public UserDataResponse getUserByUserName(String userName);
    public List<UserDataResponse> getAllUsers();
    public UserUpdateResponse updateUser(UserUpdateRequest user);
    public UserDeleteResponse deleteUser(UserDeleteRequest user);
}
