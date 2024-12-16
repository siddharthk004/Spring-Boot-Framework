package com.smart.smartcontactmanager.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smart.smartcontactmanager.dao.userRepo;
import com.smart.smartcontactmanager.entities.user;


@Controller
@RequestMapping("/user")
public class userController {

    @Autowired
    private userRepo userRepo;

    @RequestMapping("/index")
    public String dashboard(Model model,Principal principal) 
    {
    try {
        String userName = principal.getName();
        System.out.println("Username: " + userName);
        user user = this.userRepo.getUserByUserName(userName);
        model.addAttribute("user", user);
        return "normal/user_dashboard";
    } catch (Exception e) {
        e.printStackTrace();
        return "error"; // Redirect to an error page or message
    }
  }
}
