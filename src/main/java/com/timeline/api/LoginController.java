package com.timeline.api;

import com.timeline.dto.request.RequestAccount;
import com.timeline.dto.response.ResponseAccount;
import com.timeline.service.LoginService;
import lombok.RequiredArgsConstructor;
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
    public ResponseEntity<ResponseAccount> accountSignUp(@Valid @RequestBody RequestAccount account) {
        return new ResponseEntity<>(loginService.accountSignUp(account), HttpStatus.OK);
    }

}
