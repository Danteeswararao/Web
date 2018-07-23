package com.love2code.springdemo;

public class CricketCoach implements Coach {

	private FortuneServices fortuneService;
	private String emailAddress;
	private String team;
	
	public void setEmailAddress(String emailAddress) {
		//System.out.println("CricketCoach : Inside setter-method - setEmailAddress");
		this.emailAddress = emailAddress;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		//System.out.println("CricketCoach : Inside setter-method - setTeam");
		this.team = team;
	}

	public CricketCoach() {
		//System.out.println("CricketCoach : Inside no-arg Constructor");
	}
	
	public void setFortuneService(FortuneServices fortuneService) {
		//System.out.println("CricketCoach : Inside setter-method - setFortuneService");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkOut() {
		return "Practice fast bowling for 30 mins";
	}

	@Override
	public String getProfile() {
		return "HI My name is Dantesh and I am a Cricket Coach";
	}

	@Override
	public String getDailyFortune() {
		return "CricketCoach : " + fortuneService.getFortune();
	}

}
