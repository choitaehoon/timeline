package com.timeline.dto.response;

import lombok.Getter;

import java.util.List;

@Getter
public class ResponseAccountFriendList {

    private final List<String> friends;

    private final int size;

    public ResponseAccountFriendList(List<String> friendsList) {
        this.friends = friendsList;
        this.size = friends.size();
    }

}
