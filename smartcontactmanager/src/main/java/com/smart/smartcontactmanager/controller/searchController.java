package com.smart.smartcontactmanager.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.smart.smartcontactmanager.dao.contactRepo;
import com.smart.smartcontactmanager.dao.userRepo;
import com.smart.smartcontactmanager.entities.contact;
import com.smart.smartcontactmanager.entities.user;

@RestController
public class searchController {
    @Autowired
    private userRepo userRepo;

    @Autowired
    private contactRepo contactRepo;
    
    // search Handler
    @GetMapping("/search/{query}")
    public ResponseEntity<?> search(@PathVariable("query") String query,Principal principal)
    {
        System.out.println(query);
        user user = this.userRepo.getUserByUserName(principal.getName());

        List<contact> contacts = this.contactRepo.findByNameContainingAndUser(query, user);
        return ResponseEntity.ok(contacts);
    }
}
