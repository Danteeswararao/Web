package com.love2code.springdemo;

public class BaseballCoach implements Coach {
	
	//define private field and define constructor for dependency injection 
	private FortuneServices fortuneService;
	
	public BaseballCoach(FortuneServices thefortuneService) {
		fortuneService = thefortuneService;
	}
	
	@Override
	public String getDailyWorkOut() {
		return "Spend 30 mins on Batting Practice";
	}
	@Override
	public String getProfile() {
		return "HI My name is Dantesh and I am a Baseball Coach";
	}
	@Override
	public String getDailyFortune() {
		//use my fortune services
		return fortuneService.getFortune();
	}
}
