package com.love2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.love2code.aopdemo.dao.AccountDAO;
import com.love2code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		//read spring config class
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		//get the bean from container
		AccountDAO theAccountDAO = context.getBean("accountDAO" , AccountDAO.class);
		//call business method
		MembershipDAO themembershipDAo = context.getBean("membershipDAO",MembershipDAO.class);
		
		Account theAccount = new Account();
		
		theAccountDAO.addAccount(theAccount,true);
		
		theAccountDAO.doWork();
		
		theAccountDAO.setName("Dantesh");
		
		theAccountDAO.setServiceCode("IT");
		
		String name  = theAccountDAO.getName();
		
		String serviceCode = theAccountDAO.getServiceCode();
		
		System.out.println(name + " " +serviceCode );
		
		
		//System.out.println("let's call again.....");	
	
		
		themembershipDAo.addAccount();
		themembershipDAo.goToSleep();
		
		//close context
		context.close();

	}

}
