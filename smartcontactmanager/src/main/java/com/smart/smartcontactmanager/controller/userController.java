package com.smart.smartcontactmanager.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smart.smartcontactmanager.dao.userRepo;
import com.smart.smartcontactmanager.entities.contact;
import com.smart.smartcontactmanager.entities.user;


@Controller
@RequestMapping("/user")
public class userController {

    @Autowired
    private userRepo userRepo;

    // method for adding common data to response
    @ModelAttribute
    public void addCommonData(Model model,Principal principal) {
        
        String userName = principal.getName();
        System.out.println("Username: " + userName);
        
        user user = this.userRepo.getUserByUserName(userName);
        model.addAttribute("user", user); 
    }

    // home dashboard
    @RequestMapping("/index")
    public String dashboard(Model model,Principal principal) 
    {
    try {  
        model.addAttribute("title","User Dashboard");

        return "normal/user_dashboard";
    } catch (Exception e) {
        e.printStackTrace();
        return "error"; // Redirect to an error page or message
    } 
    }

    // open add form controller
    @GetMapping("/add_contact")
    public String openAddContactForm(Model model) {
        model.addAttribute("title","Add Contact Detail");
        model.addAttribute("contact",new contact());
        return "normal/add_contact_form";
    }
}
