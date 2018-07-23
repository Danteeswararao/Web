package com.love2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	//start with @Before advice 
	@Before("execution(* com.love2code.aopdemo.dao.*.*(..))")
	//@Before("execution(public void updateAccount())")
	public void beforeAddAccount() {
		
		System.out.println("===> Before Add Account <===");
	}
	
}
