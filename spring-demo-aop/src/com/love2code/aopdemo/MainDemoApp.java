package com.love2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.love2code.aopdemo.dao.AccountDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		//read spring config class
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		//get the bean from container
		AccountDAO theAccountDAO = context.getBean("accountDAO" , AccountDAO.class);
		//call business method
		theAccountDAO.addAccount();
		System.out.println("let's call again.....");	
		theAccountDAO.addAccount();
		
		//close context
		context.close();

	}

}
