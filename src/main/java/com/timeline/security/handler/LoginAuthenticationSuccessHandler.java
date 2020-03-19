package com.timeline.security.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.timeline.dto.WebToken;
import com.timeline.security.AccountContext;
import com.timeline.security.jwt.JwtFactory;
import com.timeline.security.tokens.PostAuthorizationToken;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@RequiredArgsConstructor
public class LoginAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private final JwtFactory factory;
    private final ObjectMapper objectMapper;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication)
            throws IOException, ServletException {
        PostAuthorizationToken token = (PostAuthorizationToken) authentication;
        AccountContext context = (AccountContext) token.getPrincipal();
        String tokenResult = factory.createToken(context);
        processResponse(httpServletResponse, turnToken(tokenResult));
    }

    private void processResponse(HttpServletResponse response, WebToken token) throws IOException {
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        response.setStatus(HttpStatus.OK.value());
        response.getWriter().write(objectMapper.writeValueAsString(token));
    }

    private WebToken turnToken(String token) {
        return WebToken.builder()
                .token(token)
                .build();
    }

}
