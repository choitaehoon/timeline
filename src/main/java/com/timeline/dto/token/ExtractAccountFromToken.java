package com.timeline.dto.token;

import com.timeline.security.tokens.PostAuthorizationToken;
import org.springframework.security.core.Authentication;

public class ExtractAccountFromToken {

    public static String getUsernameFromAuthentication(Authentication authentication) {
        PostAuthorizationToken token = (PostAuthorizationToken) authentication;
        return token.getAccountContext().getUsername();
    }
}
