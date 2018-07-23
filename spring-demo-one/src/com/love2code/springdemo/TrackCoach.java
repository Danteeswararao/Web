package com.love2code.springdemo;

public class TrackCoach implements Coach {

private FortuneServices fortuneService;
	
	public TrackCoach(FortuneServices thefortuneService) {
		fortuneService = thefortuneService;
	}
	
	@Override
	public String getDailyWorkOut() {
		return "Run a hard 5K";
	}
	@Override
	public String getProfile() {
		return "HI My name is Dantesh and I am a Track Coach";
	}
	@Override
	public String getDailyFortune() {
		//use my fortune services
		return "Just Do it : " + fortuneService.getFortune();
	}
	
	//add an init method
	
	public void doStartUpStuff()
	{
		System.out.println("Inside init methode");
	}
	
	//add an destroy methode
	public void doCleanUpStuff()
	{
		System.out.println("Inside destroy methode");
	}
	
}
