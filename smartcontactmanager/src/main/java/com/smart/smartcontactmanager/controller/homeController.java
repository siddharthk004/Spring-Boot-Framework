package com.smart.smartcontactmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
    private BCryptPasswordEncoder passwordEncoder;

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
    public String registerUser(@Valid @ModelAttribute("user") user user,BindingResult result1,
    @RequestParam(value = "agreement",defaultValue = "false") boolean agreement,Model model,HttpSession session)
    {
        try 
        {     
            if (!agreement) {
                System.out.println("You have not agreed to terms and conditions");
                session.setAttribute("message", new message("You must agree to the terms and conditions", "alert-danger"));
                model.addAttribute("user", user); // Retain form data
                return "signup";
            }
            
            if(result1.hasErrors())
            {
                System.out.println("Error "+result1.toString());
                model.addAttribute("user",user);
                return "signup";
            }

            user.setRoll("ROLE_USER");
            user.setEnabled(true);
            user.setImageURL("Default.png");
            user.setPassword(passwordEncoder.encode(user.getPassword()));

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

    
    @GetMapping("/signin")
    public String customLogin(Model model) {
        model.addAttribute("title","Login page ");
        return "login";
    }
    
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @PostMapping("/signin")
    public String signin(@RequestParam String username, 
                         @RequestParam String password, 
                         Model model) {
        try {
            // Authenticate the user
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password));
            
            SecurityContextHolder.getContext().setAuthentication(authentication);
    
            // Redirect to the dashboard on successful authentication
            return "/normal/user_dashboard.html";
        } catch (BadCredentialsException e) {
            // Add an error message to the model for invalid credentials
            model.addAttribute("error", "Invalid username or password");
            return "login"; // Return to login page on failure
        }
    }

    
    

    // @Autowiredw
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
