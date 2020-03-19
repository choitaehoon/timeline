package com.timeline.security.providers;

import com.timeline.domain.Account;
import com.timeline.repository.AccountRepository;
import com.timeline.security.AccountContext;
import com.timeline.security.tokens.PostAuthorizationToken;
import com.timeline.security.tokens.PreAuthorizationToken;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.NoSuchElementException;

@Configuration
@RequiredArgsConstructor
public class LoginAuthenticationProvider implements AuthenticationProvider {

    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        PreAuthorizationToken token = (PreAuthorizationToken) authentication;

        String username = token.getUsername();
        String password = token.getPassword();

        Account account = accountRepository.findByUserId(username)
                .orElseThrow(() -> new NoSuchElementException("정보에 맞는 계정이 없습니다"));

        if (isCorrectPassword(password, account)) {
            return PostAuthorizationToken.getTokenFromAccountContext(AccountContext.accountModel(account));
        }

        throw new NoSuchElementException("인증 정보가 정확하지 않습니다.");
    }

    private boolean isCorrectPassword(String password, Account account) {
        return passwordEncoder.matches(password, account.getPassword());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return PreAuthorizationToken.class.isAssignableFrom(authentication);
    }

}
