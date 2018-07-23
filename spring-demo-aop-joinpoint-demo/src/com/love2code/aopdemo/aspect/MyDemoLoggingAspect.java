package com.love2code.aopdemo.aspect;



import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.love2code.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	//start with @Before advice 
	@Before("com.love2code.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccount(JoinPoint theJoinPoint) {
		
		System.out.println("===> Before Add Account <===");
		
		//display methode signature and args
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		
		System.out.println("Methode Signature : " + methodSig);
		
		Object[] args = theJoinPoint.getArgs();
		
		for (Object tempArg : args) {
			System.out.println("Arguments : " + tempArg);
			if(tempArg instanceof Account )
			{
				Account theAccount = (Account) tempArg;
				System.out.println("Account name : " + theAccount.getName());
				System.out.println("Account Level : " + theAccount.getLevel());
			}
			
		}
		
		
	}
}
