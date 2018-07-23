package com.love2code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.love2code.aopdemo.Account;

@Component
public class AccountDAO {
	
	public void addAccount(Account theAccount , boolean vipFlag) {
		
		System.out.println(getClass() + " Doing my DB work : adding an account ");
		
	}
	
	public boolean doWork() {
		
		System.out.println(getClass() + " : Do Work ");
		return false;
	}

}
