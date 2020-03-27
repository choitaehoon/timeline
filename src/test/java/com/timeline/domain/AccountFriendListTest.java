package com.timeline.domain;

import com.timeline.config.PasswordEncoderTestConfig;
import com.timeline.dto.response.ResponseAccountFriendList;
import com.timeline.repository.AccountFriendListRepository;
import com.timeline.repository.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import(PasswordEncoderTestConfig.class)
class AccountFriendListTest {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountFriendListRepository accountFriendListRepository;

    private Account account;

    private AccountFriendList accountFriendList1;

    private AccountFriendList accountFriendList2;

    private int LIST_TWO_COUNT = 2;

    @BeforeEach
    public void setUp() {
        account = Account.builder()
                .userId("test")
                .password(passwordEncoder.encode("1234"))
                .accountRole(AccountRole.USER)
                .build();

        accountRepository.save(account);
    }

    @Test
    public void friends_List_two_expect() {
        insertFriend();

        ResponseAccountFriendList responseAccountFriendList =
                new ResponseAccountFriendList(accountFriendListRepository.findByUserId("test"));

        assertThat(responseAccountFriendList.getSize()).isEqualTo(LIST_TWO_COUNT);
    }

    @Test
    public void friends_list_zero_expect() {
        ResponseAccountFriendList responseAccountFriendList =
                new ResponseAccountFriendList(accountFriendListRepository.findByUserId("test2"));

        assertThat(responseAccountFriendList.getSize()).isZero();
    }

    private void insertFriend() {
        accountFriendList1 = AccountFriendList.builder()
                .userId("test")
                .userFriends("testFriend1")
                .build();

        accountFriendList2 = AccountFriendList.builder()
                .userId("test")
                .userFriends("testFriend2")
                .build();

        accountFriendListRepository.save(accountFriendList1);
        accountFriendListRepository.save(accountFriendList2);
    }

}