package com.timeline.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class AccountFriendList {

    @Id @GeneratedValue
    private Long id;

    private String userId;

    private String userFriends;

    @Builder
    public AccountFriendList(String userId, String userFriends) {
        this.userId = userId;
        this.userFriends = userFriends;
    }
}
