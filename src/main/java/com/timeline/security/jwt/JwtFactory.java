package com.timeline.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.timeline.security.AccountContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.io.UnsupportedEncodingException;

@Slf4j
@Configuration
public class JwtFactory {

    @Value("${string.SIGN_KEY}")
    private String SIGN_KEY;

    public String createToken(AccountContext context) {

        String token = null;

        try {
            token = JWT.create()
                    .withIssuer("timeline")
                    .withClaim("USERNAME", context.getAccount().getUserId())
                    .withClaim("USER_ROLE", context.getAccount().getAccountRole().getRoleName())
                    .sign(generateAlgorithm());
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        return token;
    }

    private Algorithm generateAlgorithm() throws UnsupportedEncodingException {
        return Algorithm.HMAC256(SIGN_KEY);
    }
}
