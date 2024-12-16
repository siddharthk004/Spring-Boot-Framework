package com.smart.smartcontactmanager.config;

import java.util.Collection;

import org.apache.catalina.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.smart.smartcontactmanager.entities.user;

public class customUserDetails implements UserDetails {
    private user user;
    

    public customUserDetails(com.smart.smartcontactmanager.entities.user user2) {
        super();
        this.user = user2;
    }

    public customUserDetails(User user2) {
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(user.getRoll());
        return java.util.List.of(simpleGrantedAuthority);
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }
}
