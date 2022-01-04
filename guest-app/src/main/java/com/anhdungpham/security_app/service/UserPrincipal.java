package com.anhdungpham.security_app.service;

import com.anhdungpham.security_app.entity.AuthorizationEntity;
import com.anhdungpham.security_app.entity.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

public class UserPrincipal implements UserDetails {
    private final UserEntity userEntity;
    private final List<AuthorizationEntity> authGroups;

    public UserPrincipal(UserEntity userEntity, List<AuthorizationEntity> authGroups) {
        super();
        this.userEntity = userEntity;
        this.authGroups = authGroups;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (null == authGroups) {
            return Collections.emptySet();
        }
        Set<SimpleGrantedAuthority> grantedAuthority = new HashSet<>();
        authGroups.forEach(authGroup -> {
            grantedAuthority.add(new SimpleGrantedAuthority(authGroup.getAuthGroup()));
        });
        return grantedAuthority;
    }

    @Override
    public String getPassword() {
        return userEntity.getPassword();
    }

    @Override
    public String getUsername() {
        return userEntity.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
