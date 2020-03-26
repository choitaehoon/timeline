package com.timeline.repository;

import com.timeline.domain.AccountFriendList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccountFriendListRepository extends JpaRepository<AccountFriendList, Long> {

    @Query("SELECT F.userFriends from AccountFriendList AS F where F.userId = ?1")
    List<String> findByUserId(String userId);
}
