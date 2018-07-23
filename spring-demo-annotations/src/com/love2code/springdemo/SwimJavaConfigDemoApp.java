package com.love2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
	
		//Load Spring Config file
		//ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//Load using java config
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);	
		//get the beam from spring container
		//Coach theCoach = context.getBean("swimCoach",Coach.class);
		SwimCoach theCoach = context.getBean("swimCoach",SwimCoach.class);
		//call some methods
		System.out.println(theCoach.getDailyWorkOut());
		//call the fortune methode
		System.out.println(theCoach.getFortuneService());
		
		//call our new swim coach methods ..has props file injection
		
		System.out.println("Email id : " + theCoach.getEmail());
		System.out.println("Team : " + theCoach.getTeam());
		
		//close context
		context.close();
	}

}
