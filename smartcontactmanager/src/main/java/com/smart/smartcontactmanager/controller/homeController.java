package com.smart.smartcontactmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.smart.smartcontactmanager.dao.userRepo;
// import com.smart.smartcontactmanager.dao.userRepo;
// import com.smart.smartcontactmanager.entities.contact;
import com.smart.smartcontactmanager.entities.user;
import com.smart.smartcontactmanager.helper.message;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;


@Controller
public class homeController {

    @Autowired
    private userRepo userRepo;

    @RequestMapping("/")    
    public String home(Model model)
    {
        model.addAttribute("title","Home - Smart Contact Manager");

        return "home";
    }
    @RequestMapping("/about")    
    public String about(Model model)
    {
        model.addAttribute("title","About - Smart Contact Manager");

        return "about";
    }
    
    @RequestMapping("/signup")    
    public String SignUp(Model model)
    {
        model.addAttribute("title","Register- Smart Contact Manager");
        model.addAttribute("user",new user());
        return "signup";
    }

    // this handler for registering user 
    @RequestMapping(value="/do_register",method=RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") user user,@RequestParam(value = "agreement",defaultValue = "false") boolean agreement,Model model,HttpSession session)
    {
        try 
        {     
            if(!agreement){
                System.out.println("You have not agrred to terms and conditions");
                throw new Exception("You have not agrred to terms and conditions");
            }

            user.setRoll("Role_User");
            user.setEnabled(true);
            user.setImageURL("Default.png");
            System.out.println("Agrrement : "+agreement);
            System.out.println("User : "+user);

            this.userRepo.save(user);        

            model.addAttribute("user",new user());
            session.setAttribute("message",new message("Successfully Registered","alert-success"));
            return "signup";
        }
        catch(Exception e) 
        {
            e.printStackTrace();
            model.addAttribute("user", user);
            session.setAttribute("message",new message("Something Went Wrong"+e.getMessage(),"alert-danger"));
            return "signup";
        }
    }

    @RequestMapping("/login")    
    public String login(Model model)
    {
        model.addAttribute("title","Login- Smart Contact Manager");

        return "login";
    }

    
    // @Autowired
    // private userRepo userrepo;

    // @GetMapping("/test")
    // @ResponseBody   
    // public String test() {

    //     user user = new user();
    //     user.setName("Siddharth");
    //     user.setEmail("SiddharthKArdile5@gmail.com");
        
    //     contact contact = new contact();
    //     user.getContacts().add(contact);

    //     userrepo.save(user);
        
    //     return "Working";
    // }
}
