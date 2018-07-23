package com.love2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp {

	public static void main(String[] args) {
		//Load spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		//retrieve bean from spring container
		Coach theCoach = context.getBean("myCoach",Coach.class);
		
		Coach alphaCoach = context.getBean("myCoach",Coach.class);
		
		boolean result = ( theCoach == alphaCoach );
		System.out.println("\n Ponint the same objects " + result + "\n");
		System.out.println("\n Memory loaction of theCoach " + theCoach);
		System.out.println("\n Memory location of alphaCoach " + alphaCoach);
		//close the context
		context.close();
		
	}

}
