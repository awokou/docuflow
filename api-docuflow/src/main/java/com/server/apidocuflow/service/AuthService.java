package com.server.apidocuflow.service;

import com.server.apidocuflow.domain.dto.external.LoginDto;
import com.server.apidocuflow.domain.dto.response.AuthResponse;

public interface AuthService {

    AuthResponse login(LoginDto loginDto);
}
