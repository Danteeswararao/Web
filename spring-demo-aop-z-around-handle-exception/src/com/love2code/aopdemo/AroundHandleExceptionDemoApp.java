package com.love2code.aopdemo;


import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.love2code.aopdemo.services.TrafficFortuneService;


public class AroundHandleExceptionDemoApp {

	
	private static Logger myLogger = Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());
	
	public static void main(String[] args) {
		
		//read spring config class
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		//get the bean from container
		TrafficFortuneService theFortune = context.getBean("trafficFortuneService" , TrafficFortuneService.class);
		//call business method
		
		myLogger.info("\n Main Programme \n");
		myLogger.info("Calling getFortune");
		
		boolean tripWire = true;
		String data = theFortune.getFortune(tripWire);
		
		myLogger.info("\n My Fortune is : " + data + "\n");
		myLogger.info("Finished");
		//close context
		context.close();

	}

}
