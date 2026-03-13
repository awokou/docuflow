package com.server.apidocuflow.service.impl;

import com.server.apidocuflow.domain.dto.external.UserDto;
import com.server.apidocuflow.domain.dto.response.UserResponse;
import com.server.apidocuflow.domain.entity.User;
import com.server.apidocuflow.exception.ResourceNotFoundException;
import com.server.apidocuflow.repository.UserRepository;
import com.server.apidocuflow.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
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
    @Transactional
    public UserDto updateUser(Long id, UserDto userDto) {
      return null;
    }

    @Override
    @Transactional
    public void deleteUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with id " + id + " does not exist"));

        userRepository.delete(user);
    }
}
