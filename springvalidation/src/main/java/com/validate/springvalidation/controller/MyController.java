package com.validate.springvalidation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.validate.springvalidation.entities.LoginatData;
import jakarta.validation.Valid;

@Controller
public class MyController {

    @GetMapping("/form")
    public String OPenForm(Model model) {
        System.out.println("Opening Form");
        model.addAttribute("loginData",new LoginatData());
        return "form";
    }
    //  handler for processing form
    @PostMapping("/process")
    public String ProcessingForm(@Valid @ModelAttribute("loginData") LoginatData logindata,BindingResult result) {
        if(result.hasErrors()) {
            System.out.println(result);
            return "form";
        }
        System.out.println(logindata);
        return "success";
    }
}
