package com.smart.smartcontactmanager.controller;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;


// import com.smart.smartcontactmanager.dao.userRepo;
// import com.smart.smartcontactmanager.entities.contact;
// import com.smart.smartcontactmanager.entities.user;


@Controller
public class homeController {

    @RequestMapping("/home")    
    public String home(Model model)
    {
        model.addAttribute("title","Home - Smart Contact Manager");

        return "home";
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
