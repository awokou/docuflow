package com.server.apidocuflow.service;

import com.server.apidocuflow.domain.dto.external.UserDto;
import com.server.apidocuflow.domain.dto.response.UserResponse;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto userDto);

    List<UserResponse> findAll();

    UserResponse findAllById(Long id);

    UserDto updateUser(Long id,UserDto userDto);

    void deleteUserById(Long id);
}
