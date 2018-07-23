package com.love2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {
		//Load spring configuration file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		//retrieve bean objects from spring container
		CricketCoach theCoach = context.getBean("myCricketCoach" , CricketCoach.class);
		//call the methods on the bean 
		System.out.println("My profile is :" + theCoach.getProfile());
		System.out.println("My Daily Workout is : " + theCoach.getDailyWorkOut());
		System.out.println("My Fortune is : " + theCoach.getDailyFortune());
		//call the literal values
		System.out.println("My Email id is : " + theCoach.getEmailAddress());
		System.out.println("My Fav Team in IPL : "+ theCoach.getTeam());
		//close context object
		context.close();
	}

}
