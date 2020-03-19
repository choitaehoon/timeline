package com.timeline.security;

import com.timeline.domain.Account;
import com.timeline.domain.AccountRole;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AccountContext extends User {

    public AccountContext(String userId, String password, Collection<? extends GrantedAuthority> authorities) {
        super(userId, password, authorities);
    }

    public static AccountContext accountModel(Account account) {
        return new AccountContext(account.getUserId(), account.getPassword(), changeAccountRoleToList(account.getAccountRole()));
    }

    private static List<SimpleGrantedAuthority> changeAccountRoleToList(AccountRole accountRole) {
        return Stream.of(accountRole)
                .map(r -> new SimpleGrantedAuthority(r.getRoleName()))
                .collect(Collectors.toList());
    }

}
