package com.love2code.mvc.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/helloworld")
public class TestController {
	
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld1";
	}

}
