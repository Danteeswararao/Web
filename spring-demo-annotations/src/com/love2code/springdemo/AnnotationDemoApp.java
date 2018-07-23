package com.love2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
	
		//Load Spring Config file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
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
