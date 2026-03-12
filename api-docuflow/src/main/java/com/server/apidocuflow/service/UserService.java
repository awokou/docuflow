package com.server.apidocuflow.service;

import com.server.apidocuflow.domain.dto.external.LoginDto;
import com.server.apidocuflow.domain.dto.external.UserDto;
import com.server.apidocuflow.domain.dto.response.AuthResponse;
import com.server.apidocuflow.domain.dto.response.UserResponse;

import java.util.List;

public interface UserService {

    AuthResponse createUser(UserDto userDto);

    AuthResponse login(LoginDto loginDto);

    List<UserResponse> findAll();

    UserResponse findAllById(Long id);

    void updateUser(Long id,UserDto userDto);

    void deleteUserById(Long id);
}
