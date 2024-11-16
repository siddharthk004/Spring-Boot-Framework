package com.practice.thymeleafpractical.controller;

// import java.util.Date;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// import ch.qos.logback.core.model.Model;

@Controller
public class MyController {

    @RequestMapping(value="/about",method=RequestMethod.GET)
    public String about(Model model) {
        System.out.println("inside about to handler");

        // putting data in to model
        model.addAttribute("Name","Siddharth Kardile");
        model.addAttribute("CurrentDate1",new Date(14).toLocalDate());
        
        return "About";
        // we have to show About.html page Content
    }

    // handing iteration
    @GetMapping("/example-loop")
    public String iterateHandler(Model m) {
        List<String> names = List.of("Ankit","Laxmi","Karan","John");
        
        m.addAttribute("name", names);
        
        return "iterate";
    }

    // handler for conditional statement 
    @GetMapping("/condition")
    public String ConditionalHandler(Model model) {
        System.out.println("Conditional Handler Executed");
        model.addAttribute("isActive", true);
        model.addAttribute("gender", "M");
        List<Integer> list = List.of(23,34,25,563,345,654,23);
        model.addAttribute("myList", list);
        return "condition";
    }

    // handler for including fragments
    @GetMapping("/service")
    public String ServicesHandler(Model model) {
        model.addAttribute("title", "I like to Eat Samosa");
        model.addAttribute("subtitle", LocalDateTime.now().toString());
        return "service";
    }

    // for new about
    @GetMapping("/newabout")
    public String newAbout(){
        return "aboutnew";
    }
    
    // for new contact
    @GetMapping("/contact")
    public String contact(){
        return "contact";
    }
}
