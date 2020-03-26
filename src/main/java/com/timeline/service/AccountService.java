package com.timeline.service;

import com.timeline.dto.response.ResponseAccountFriendList;
import com.timeline.repository.AccountFriendListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountFriendListRepository accountFriendListRepository;

    public ResponseAccountFriendList findFriends(String userId) {
        return new ResponseAccountFriendList(accountFriendListRepository.findByUserId(userId));
    }

}
