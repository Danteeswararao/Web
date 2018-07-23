package com.love2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		
		//Load the spring configuration file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		//Retrieve the bean from spring container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		//Call methods on the bean
		System.out.println(theCoach.getDailyWorkOut());
		//System.out.println(theCoach.getProfile());
		//let's call new fortune method
		System.out.println(theCoach.getDailyFortune());
		//close the context 
		context.close();
	}

}
