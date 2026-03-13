package com.server.apidocuflow.service.impl;

import com.server.apidocuflow.domain.dto.external.LoginDto;
import com.server.apidocuflow.domain.dto.response.AuthResponse;
import com.server.apidocuflow.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthService authService;

    @Override
    public AuthResponse login(LoginDto loginDto) {
        return null;
    }
}
