package com.timeline.api;

import com.timeline.dto.response.ResponseAccountFriendList;
import com.timeline.dto.token.ExtractAccountFromToken;
import com.timeline.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@CrossOrigin
@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/api/v1/friends")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<ResponseAccountFriendList> findAccountFriends(Authentication authentication) {
        return new ResponseEntity<>(accountService.findFriends(ExtractAccountFromToken.getUsernameFromAuthentication(authentication)),
                HttpStatus.OK);
    }

}
