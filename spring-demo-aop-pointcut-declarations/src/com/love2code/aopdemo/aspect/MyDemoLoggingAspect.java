package com.love2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	@Pointcut("execution(* com.love2code.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {};
	
	//start with @Before advice 
	@Before("forDaoPackage()")
	public void beforeAddAccount() {
		
		System.out.println("===> Before Add Account <===");
	}
	
	@Before("forDaoPackage()")
	public void performApiAnalytics() {
		
		System.out.println("===> Performing API Analytics <===");
	}
	
}
