package com.server.apidocuflow.service.impl;

import com.server.apidocuflow.domain.dto.external.LoginDto;
import com.server.apidocuflow.domain.dto.external.UserDto;
import com.server.apidocuflow.domain.dto.response.AuthResponse;
import com.server.apidocuflow.domain.dto.response.UserResponse;
import com.server.apidocuflow.repository.UserRepository;
import com.server.apidocuflow.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public AuthResponse createUser(UserDto userDto) {
        return null;
    }

    @Override
    public AuthResponse login(LoginDto loginDto) {
        return null;
    }

    @Override
    public List<UserResponse> findAll() {
        return List.of();
    }

    @Override
    public UserResponse findAllById(Long id) {
        return null;
    }

    @Override
    public void updateUser(Long id, UserDto userDto) {

    }

    @Override
    public void deleteUserById(Long id) {

    }
}
