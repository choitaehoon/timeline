package com.timeline.security.providers;

import com.timeline.domain.Account;
import com.timeline.repository.AccountRepository;
import com.timeline.security.AccountContext;
import com.timeline.security.tokens.PostAuthorizationToken;
import com.timeline.security.tokens.PreAuthorizationToken;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.NoSuchElementException;

@RequiredArgsConstructor
public class LoginAuthenticationProvider implements AuthenticationProvider {

    private final AccountContext accountContext;
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

        return null;
    }

    //TODO 순서가 바뀌면 안됨 -> 먼저 온 password부터
    private boolean isCorrectPassword(String password, Account account) {
        return passwordEncoder.matches(account.getPassword(), password);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return PreAuthorizationToken.class.isAssignableFrom(authentication);
    }

}
