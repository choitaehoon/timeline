package com.timeline.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(indexes = {@Index(columnList = "userId")})
public class Account {

    @Id @GeneratedValue
    private Long id;

    private String userId;

    private String name;

    private String password;

    private String address;

    private String birthday;

    private String sex;

    @Enumerated(value = EnumType.STRING)
    private AccountRole accountRole;

    @Builder
    public Account(String userId, String name, String password, String address,
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
