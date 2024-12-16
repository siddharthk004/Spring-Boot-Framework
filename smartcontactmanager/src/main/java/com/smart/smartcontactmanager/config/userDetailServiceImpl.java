package com.smart.smartcontactmanager.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.smart.smartcontactmanager.dao.userRepo;
import com.smart.smartcontactmanager.entities.user;

public class userDetailServiceImpl implements UserDetailsService{
    
    @Autowired
    private userRepo userrepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        user user = userrepo.getUserByUserName(username);

        if(user == null) {
            throw new UsernameNotFoundException("Could Not Found Exception !! ");
        }

        customUserDetails customUserDetails = new customUserDetails(user);

        
        return customUserDetails;
    }
}
