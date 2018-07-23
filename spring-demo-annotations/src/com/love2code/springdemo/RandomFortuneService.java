package com.love2code.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	private String data[] = {
			
			"Today is your lucky day.",
			"Never give up.",
			"Beware of the wolf.",
			"An apple a day keeps the doctor away.",
			"A bird in hand is better than two in a bush."
			
	};
	
	
	Random random = new Random();
	int index = random.nextInt(data.length);
	String theFortune = data[index];
	@Override
	public String getFortuneService() {
		// TODO Auto-generated method stub
		return theFortune;
	}

}
