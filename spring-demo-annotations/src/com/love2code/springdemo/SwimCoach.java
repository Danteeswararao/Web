package com.love2code.springdemo;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {

	private FortuneService fortuneservice;
	
	@Value("${foo.email}")
	private String email;
	@Value("${foo.team}")
	private String team;
	
	
	public SwimCoach(FortuneService theFortuneservice) {
		fortuneservice = theFortuneservice;
	}
	
	@Override
	public String getDailyWorkOut() {
		return "Swim 1000 meters for warm up";
	}

	@Override
	public String getFortuneService() {
		
		return fortuneservice.getFortuneService();
	}

	public String getEmail() {
		return email;
	}

	public String getTeam() {
		return team;
	}
	

}
