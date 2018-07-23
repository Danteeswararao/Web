package com.love2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class TennisCoach implements Coach {

	@Autowired
	@Qualifier("happyFortuneService")
	private FortuneService fortuneService;
	
	public TennisCoach() {
		System.out.println("Inside default constructor");
	}
	
	//define init method
	/*@PostConstruct
	public void doStartUpStuff() {
		System.out.println("Inside doStartUpStuff");
	}
	
	//define destroy method
	@PreDestroy
	public void doCleanUpStuff() {
		System.out.println("Inside doCleanUpStuff");
	}
	
	//define method injection
	/*@Autowired
	public void doSomeCrazyStuff(FortuneService fortuneService) {
		System.out.println("Inside doSomeCrazyStuff method");
		this.fortuneService = fortuneService;
	}
	//define setter injection
	@Autowired
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("Inside setter method");
		this.fortuneService = fortuneService;
	}
	//define constructor injection
	@Autowired
	public TennisCoach(FortuneService thefortuneService) {
		fortuneService = thefortuneService;
	}*/
	
	@Override
	public String getDailyWorkOut() {
		
		return " Practice more and more ";
	}

	@Override
	public String getFortuneService() {
		return fortuneService.getFortuneService();
	}

}
