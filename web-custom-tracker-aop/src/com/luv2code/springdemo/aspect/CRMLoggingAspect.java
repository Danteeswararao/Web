package com.luv2code.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
	
	//setup a logger 
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	//setup Point cut expressions
	@Pointcut("execution(* com.luv2code.springdemo.controller.*.*(..))")
	private void forControllerPackage() {}
	
	@Pointcut("execution(* com.luv2code.springdemo.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {}
	
	//Add @Before Advice
	
	@Before("forAppFlow()")
	private void before(JoinPoint theJoinPoint) {
		
		//Display method we are calling 
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("=====> in @Before : calling method " + theMethod);
		//Display the arguments for method
		Object[] args = theJoinPoint.getArgs();
		for (Object tempArg : args ) {
			
			myLogger.info("=====> Arguments " + tempArg);
			
		}
		
	}
	
	//Add AfterReturn Advice
	@AfterReturning(
			pointcut="forAppFlow()",
			returning="theResult"
			)
	public void afterReturning(JoinPoint theJoinPoint ,Object theResult) {
		
		//Display the method which we are returning from
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("=====> in @AfterReturning : from method " + theMethod);
		//Display the data returned 
		myLogger.info("=====> Result " +theResult);
	}
	
}
