package com.timeline.api;

import com.timeline.domain.Account;
import com.timeline.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/account")
    public ResponseEntity<Account> accountSignUp(@Valid @RequestBody Account account) {
        return new ResponseEntity<>(loginService.accountSignUp(account), HttpStatus.OK);
    }

}
