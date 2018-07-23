package com.love2code.mvc.demo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

	//Need a controller method to show initial HTML form 
	@RequestMapping("/showForm")
	public String showForm(){
		return "helloworld-form";
	}
	
	//Need a controller method to process the HTML form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	@RequestMapping("/processFormVersionTwo")
	//new controller method to read form data
	//add data to model
	
	public String readForm(HttpServletRequest request, Model model) {
	
		//read parameter from request object 
		String theName = request.getParameter("studentName");
		//Do some processing 
		theName = theName.toUpperCase();
		//create a message 
		String result = "Yo! " + theName;
		//add message to model
		model.addAttribute("message",result);
		return "helloworld";
	}
	
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(@RequestParam("studentName") String theName, Model model) {
	
		//Do some processing 
		theName = theName.toUpperCase();
		//create a message 
		String result = "Hey my friend from v3 " + theName;
		//add message to model
		model.addAttribute("message",result);
		return "helloworld";
	}
}
