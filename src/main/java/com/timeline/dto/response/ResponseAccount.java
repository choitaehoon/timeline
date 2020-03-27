package com.timeline.dto.response;

import com.timeline.domain.Account;
import lombok.Getter;

@Getter
public class ResponseAccount {

    private final Account account;

    public ResponseAccount(Account account) {
        this.account = account;
    }
}
