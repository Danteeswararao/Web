package com.love2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
	
	public void addAccount() {
		
		System.out.println(getClass() + " Doing my DB work : adding an account ");
		
	}

}
