package com.love2code.aopdemo.aspect;



import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
	
	@Around("execution(* com.love2code.aopdemo.services.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint theProceeedingJoinPoint) throws Throwable {
		
		String method = theProceeedingJoinPoint.getSignature().toShortString();
		System.out.println("\n\n ---------> Executing @Around Advice and Methode name : "+method);
		
		long begin = System.currentTimeMillis();
		
		Object result = theProceeedingJoinPoint.proceed();
		
		long end = System.currentTimeMillis();
		
		long duration = end - begin ;
		
		System.out.println("\nDuration : " + duration / 1000.0 + " seconds ");
		
		return result;
		
	}
	
	@After("execution(* com.love2code.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountAdvice(JoinPoint theJoinPoint) {
		
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n\n ---------> Executing the After (Finally) Advice and Methode name : "+method);
		
	}
	
	@AfterThrowing(
			pointcut="execution(* com.love2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing="theException"
			)
	public void afterThrowingFindAccountAdvice(JoinPoint theJoinPoint ,Throwable theException) {
		
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n\n ---------> Executing the AfterReturning Advice and Methode name : "+method);
		
		System.out.println("\n\n ---------> Exception is : " +theException);
		
	}

	@AfterReturning(
			pointcut="execution(* com.love2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint , List<Account> result) {
		
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n\n ---------> Executing the AfterReturning Advice and Methode name : "+method);
		
		System.out.println("\n\n ---------> Result is : "+result);
		
		convertAccountNamesToUpperCase(result);
	}
	
	
	private void convertAccountNamesToUpperCase(List<Account> result) {
		
		for(Account tempAccout : result) {
			
			String theUpperName = tempAccout.getName().toUpperCase();
			tempAccout.setName(theUpperName);
			
		}
		
	}


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
				if(tempArg instanceof Account ) {
					Account theAccount = (Account) tempArg;
					System.out.println("Account name : " + theAccount.getName());
					System.out.println("Account Level : " + theAccount.getLevel());
				}
			
		}
		
		
	}
}