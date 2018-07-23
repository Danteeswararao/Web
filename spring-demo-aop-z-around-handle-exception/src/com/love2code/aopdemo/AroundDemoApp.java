package com.love2code.aopdemo;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.love2code.aopdemo.services.TrafficFortuneService;


public class AroundDemoApp {

	public static void main(String[] args) {
		
		//read spring config class
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		//get the bean from container
		TrafficFortuneService theFortune = context.getBean("trafficFortuneService" , TrafficFortuneService.class);
		//call business method
		
		System.out.println("\n Main Programme \n");
		System.out.println("Calling getFortune");
		
		String data = theFortune.getFortune();
		
		System.out.println("\n My Fortune is : " + data + "\n");
		System.out.println("Finished");
		//close context
		context.close();

	}

}
