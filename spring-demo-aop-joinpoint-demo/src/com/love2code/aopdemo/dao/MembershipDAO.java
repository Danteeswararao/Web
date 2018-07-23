package com.love2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	
	public void addAccount() {
		System.out.println(getClass() + " Doing Some work : adding an membership  ");
	}
	
	public void goToSleep() {
		System.out.println(getClass() + " I am going to sleep now...  ");
		
	}
}
