package com.love2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) {
	
		//Load Spring Config file
		//ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//Load using java config
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);	
		//get the beam from spring container
		Coach theCoach = context.getBean("tennisCoach",Coach.class);
		//call some methods
		System.out.println(theCoach.getDailyWorkOut());
		//call the fortune methode
		System.out.println(theCoach.getFortuneService());
		//close context
		context.close();
	}

}
