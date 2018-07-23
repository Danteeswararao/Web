package com.love2code.springdemo;

import java.util.Random;

public class HappyFortuneService implements FortuneServices {
	
	private String[] data = {
			
			"Beware of the wolf in sheep's clothing",
			"Diligence is the mother of good luck",
			"The journey is the reward"
			};

	private Random myRandom = new Random();
	
	
	@Override
	public String getFortune() {
		
		int index = myRandom.nextInt(data.length);
		String Fortune = data[index];
		return Fortune;
	}

}
