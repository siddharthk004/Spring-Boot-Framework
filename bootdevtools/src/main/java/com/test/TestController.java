package com.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

	@RequestMapping("/test")
	@ResponseBody
	public String test() {
		int a = 31;
		int b = 89;
		int c = 90;
		return "This is just Testing sum of a and b and c is "+ ( a + b + c );
	}

}