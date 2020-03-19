package com.timeline.security.service;

import com.timeline.domain.Account;
import com.timeline.repository.AccountRepository;
import com.timeline.security.AccountContext;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.NoSuchElementException;

@Configuration
@RequiredArgsConstructor
public class AccountContextService implements UserDetailsService {

    private final AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        Account account = accountRepository.findByUserId(userId)
                .orElseThrow(() -> new NoSuchElementException("아이디에 맞는 계정이 없습니다."));

        return getAccountContext(account);
    }

    private AccountContext getAccountContext(Account account) {
        return AccountContext.accountModel(account);
    }
}
