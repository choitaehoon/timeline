package com.timeline.security.tokens;

import com.timeline.dto.LoginDto;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class PreAuthorizationToken extends UsernamePasswordAuthenticationToken {

    private PreAuthorizationToken(String username, String password) {
        super(username, password);
    }

    public PreAuthorizationToken(LoginDto loginDto) {
        this(loginDto.getUserId(), loginDto.getPassword());
    }

    public String getUsername() {
        return (String) super.getPrincipal();
    }

    public String getPassword() {
        return (String) super.getCredentials();
    }

}
