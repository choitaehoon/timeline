package com.timeline.dto.request;

import com.timeline.config.valid.account.ValidUserIdAccount;
import com.timeline.config.valid.account.ValidUserPasswordAccount;
import com.timeline.domain.AccountRole;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@NoArgsConstructor
public class RequestAccount {

    @ValidUserIdAccount
    private String userId;

    private String name;

    @ValidUserPasswordAccount
    private String password;

    private String address;

    private String birthday;

    private String sex;

    @Enumerated(value = EnumType.STRING)
    private AccountRole accountRole;

    @Builder
    public RequestAccount(String userId, String name, String password, String address,
                          String birthday, String sex, AccountRole accountRole) {
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.address = address;
        this.birthday = birthday;
        this.sex = sex;
        this.accountRole = accountRole;
    }
}
