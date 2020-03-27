package com.timeline.service;

import com.timeline.domain.Account;
import com.timeline.domain.AccountRole;
import com.timeline.dto.request.RequestAccount;
import com.timeline.dto.response.ResponseAccount;
import com.timeline.exception.login.AccountExistCheckException;
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

    public ResponseAccount accountSignUp(RequestAccount requestAccount) {
        Account account = convertRequestAccountToAccount(requestAccount);

        isAccountExist(account.getUserId());

        accountRepository.save(account);

        return new ResponseAccount(account);
    }

    private void isAccountExist(String userId) {
        if (accountRepository.findByUserId(userId).isPresent()) {
            throw new AccountExistCheckException("아이디가 존재 합니다");
        }
    }

    public Account convertRequestAccountToAccount(RequestAccount requestAccount) {

        return Account.builder()
                .userId(requestAccount.getUserId())
                .name(requestAccount.getName())
                .password(passwordEncoder.encode(requestAccount.getPassword()))
                .address(requestAccount.getAddress())
                .birthday(requestAccount.getBirthday())
                .sex(requestAccount.getSex())
                .accountRole(AccountRole.USER)
                .build();
    }

}
