package com.smart.smartcontactmanager.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;

import com.smart.smartcontactmanager.dao.contactRepo;
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

    @Autowired
    private contactRepo contactRepo;


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

    //show contact handler
    @RequestMapping("/show-contacts")
    public String showContacts(Model model,HttpSession session,Principal principal) 
    {
        model.addAttribute("title", "Show User Contacts");
        String userName = principal.getName();
        user user = this.userRepo.getUserByUserName(userName);

        List<contact> contacts =  this.contactRepo.findContactByUser(user.getId());
        

        model.addAttribute("contacts",contacts);
        
        return "normal/show_contact";
    }

    // showing specific contact detail

    @RequestMapping("/{cId}/contact")
    public String ShowContactDet(@PathVariable("cId") Integer cId,Model Model,Principal principal) {
        System.out.println(cId);
        
        Optional<contact> contactOptional = this.contactRepo.findById(cId);
        contact contact = contactOptional.get();

        //cheak for confirming
        String username = principal.getName();
        user user = this.userRepo.getUserByUserName(username);

        if(user.getId() == contact.getUser().getId());
            Model.addAttribute("contact",contact);
        
        return "normal/contact_detail";
    }

    //delete contact hanler
    @GetMapping("/delete/{cId}")
    public String deleteContact(@PathVariable("cId") Integer cId,Model model,Principal principal,HttpSession session) {
        Optional<contact> contactOptional = this.contactRepo.findById(cId);
        contact contact = contactOptional.get();

        // cheak ... 
        String username = principal.getName();
        user user = this.userRepo.getUserByUserName(username);
        if(user.getId() == contact.getUser().getId());
            this.contactRepo.delete(contact);

        session.setAttribute("message",new message("contact Deleted Successfully","success"));
        return "redirect:/user/show-contacts";
    }

    // open update form Contact Handler
    @PostMapping("/update-contact/{cId}")
    public String updateContact(@PathVariable("cId") Integer cId,Model model) {
        model.addAttribute("Title","Update Contact");
        contact contact = this.contactRepo.findById(cId).get();
        model.addAttribute("contact",contact);
        return "normal/update_form";
    }

    //process update handler
    // @RequestMapping(value="/process-update",method = RequestMethod.POST)
    // public String updateContactHandler(@ModelAttribute contact contact,Model model,Principal principal,HttpSession session) {
    //     try {
    //         // contact oldContact = this.contactRepo.findById(contact.getcId()).get();
                
    //         user user = this.contactRepo.getUserByUserName(principal.getName());
    //         contact.setUser(user);
    //         this.contactRepo.save(contact);
        
    //         System.out.println("Contact "+contact.getName());
    //         System.out.println("Contact ");
    //         System.out.println("Contact "+contact.getcId());
        
    //     }
    //     catch(Exception e)
    //     {
    //         e.printStackTrace();
    //     }
    //     return "redirect:/user/"+contact.getcId()+"/contact";
    // }

    // Your Profile handler 
    @GetMapping("/profile")
    public String showProfile(Model model) {
        model.addAttribute("title", "Home Profile Page");
        return "normal/profile";
    }

    //setting page
    
    //show contact handler
    @RequestMapping("/setting")
    public String showContacts() 
    {
        return "normal/setting";
    }

    
}

