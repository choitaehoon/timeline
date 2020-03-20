package com.timeline.service;

import com.timeline.domain.Account;
import com.timeline.domain.AccountRole;
import com.timeline.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final PasswordEncoder passwordEncoder;
    private final AccountRepository accountRepository;

    public Account accountSignUp(Account account) {
        Account signUp = Account.builder()
                .userId(account.getUserId())
                .name(account.getName())
                .password(passwordEncoder.encode(account.getPassword()))
                .address(account.getAddress())
                .birthday(account.getBirthday())
                .sex(account.getSex())
                .accountRole(AccountRole.USER)
                .build();

        accountRepository.save(signUp);

        return signUp;
    }
}
