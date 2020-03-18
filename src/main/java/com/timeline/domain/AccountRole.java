package com.timeline.domain;

import lombok.Getter;

@Getter
public enum AccountRole {

    ADMIN("ROLE_ADMIN"),
    USER("ROLE_USER");

    private String roleName;

    AccountRole(String roleName) {
        this.roleName = roleName;
    }

}
