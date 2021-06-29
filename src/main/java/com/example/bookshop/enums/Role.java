package com.example.bookshop.enums;

import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public enum Role {

    USER(Permission.READ),
    ADMIN(Permission.READ, Permission.WRITE);

    @Getter
    private Set<Permission> permissions;

    Role(Permission... permission) {
        this.permissions = Arrays.stream(permission).collect(Collectors.toSet());
    }

    public Set<SimpleGrantedAuthority> getAuthorities() {
        return getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());

    }
}
