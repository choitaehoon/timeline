package com.timeline.api;

import com.timeline.domain.Account;
import com.timeline.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<Account> accountSignUp(@RequestBody Account account) {

        Account signUp = loginService.accountSignUp(account);

        return new ResponseEntity<>(signUp, HttpStatus.OK);
    }

}
