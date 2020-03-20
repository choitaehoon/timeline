package com.timeline.service;

import com.timeline.domain.Account;
import com.timeline.domain.AccountRole;
import com.timeline.exception.login.LoginUserIdExceptionHandler;
import com.timeline.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
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

        isAccountExist(account.getUserId());

        accountRepository.save(signUp);

        return signUp;
    }

    private void isAccountExist(String userId) {
        if (accountRepository.findByUserId(userId).isPresent()) {
            throw new LoginUserIdExceptionHandler("아이디가 존재 합니다");
        }
    }

}
