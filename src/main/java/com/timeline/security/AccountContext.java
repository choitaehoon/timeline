package com.timeline.security;

import com.timeline.domain.Account;
import com.timeline.domain.AccountRole;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AccountContext extends User {

    private Account account;

    public AccountContext(Account account, String userId, String password, Collection<? extends GrantedAuthority> authorities) {
        super(userId, password, authorities);
        this.account = account;
    }

    public AccountContext(String username, String password, String role) {
        super(username, password, parseAuthorities(role));
    }

    public static AccountContext accountModel(Account account) {
        return new AccountContext(account, account.getUserId(), account.getPassword(), changeAccountRoleToList(account.getAccountRole()));
    }

    private static List<SimpleGrantedAuthority> changeAccountRoleToList(AccountRole accountRole) {
        return Stream.of(accountRole)
                .map(r -> new SimpleGrantedAuthority(r.getRoleName()))
                .collect(Collectors.toList());
    }

    private static List<SimpleGrantedAuthority> parseAuthorities(String role) {
        return changeAccountRoleToList(AccountRole.getRoleByName(role));
    }

    public Account getAccount() {
        return account;
    }

}
