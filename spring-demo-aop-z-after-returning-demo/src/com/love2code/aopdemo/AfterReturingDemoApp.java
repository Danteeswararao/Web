package com.love2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.love2code.aopdemo.dao.AccountDAO;


public class AfterReturingDemoApp {

	public static void main(String[] args) {
		
		//read spring config class
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		//get the bean from container
		AccountDAO theAccountDAO = context.getBean("accountDAO" , AccountDAO.class);
		//call business method
		List<Account> theAccount = theAccountDAO.findAccounts();
	
		System.out.println("\n\n Main Programme : After Returning Demo App \n\n");
		System.out.println("---------------------------------------------------");
		System.out.println(theAccount);
		System.out.println("\n");
		
		//close context
		context.close();

	}

}
