package com.practice.firstmyappvs;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
        @RequestMapping("/test")
        @ResponseBody
        public String handle()
        {
            return "this is just for fun .. !!";
        } 
    
}
