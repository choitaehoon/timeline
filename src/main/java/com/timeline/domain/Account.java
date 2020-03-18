package com.timeline.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Account {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;

    private String name;

    private String password;

    private String address;

    private String birthday;

    private String sex;

    @Enumerated(value = EnumType.STRING)
    private AccountRole accountRole;

    private Long socialId;

}
