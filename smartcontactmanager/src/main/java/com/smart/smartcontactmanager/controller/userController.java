package com.smart.smartcontactmanager.controller;

import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smart.smartcontactmanager.dao.userRepo;
import com.smart.smartcontactmanager.entities.contact;
import com.smart.smartcontactmanager.entities.user;
import com.smart.smartcontactmanager.helper.message;

import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("/user")
public class userController {

    @Autowired
    private userRepo userRepo;

    // method for adding common data to response
    @ModelAttribute
    public void addCommonData(Model model, Principal principal) {
        if (principal != null) {
            String userName = principal.getName();
            user user = this.userRepo.getUserByUserName(userName);
            model.addAttribute("user", user);
        } else {
            System.out.println("Principal is null, user not authenticated.");
        }
    }
    

    // home dashboard
    @RequestMapping("/index")
    public String dashboard(Model model,Principal principal) 
    {
    try {  
        model.addAttribute("title","User Dashboard");
        return "normal/user_dashboard";
    } catch (Exception e) 
    {
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

    // process add contact form
    @PostMapping("/process-contact")
    public String processContact(@ModelAttribute contact contact,Principal principal,HttpSession session) {
        try {
        String name = principal.getName();
        
        user user = this.userRepo.getUserByUserName(name);

        contact.setUser(user);
        user.getContacts().add(contact);

        this.userRepo.save(user);
        System.out.println("Added to database");

        // message success
        session.setAttribute("message",new message("Your Contact is added !! Add more","success"));
        }
        catch(Exception e) {
            System.out.println("ERROR "+e.getMessage());
            e.printStackTrace();
            // message error
            session.setAttribute("message",new message("Something Went Wrong !! Try Again","danger"));
        }
        return "normal/add_contact_form";
    }

}
