package com.love2code.springdemo;

public class SadFortuneService implements FortuneService {

	@Override
	public String getFortuneService() {
		return "Today is bad day!!!";
	}

}
