package com.love2code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.love2code.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;
	
	
	public String getName() {
		
		System.out.println(getClass() + " in getName() ");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + " in setName(String name) ");
		this.name = name;
	}

	public String getServiceCode() {
		
		System.out.println(getClass() + " in getServiceCode() ");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		
		System.out.println(getClass() + " in setServiceCode(String serviceCode) ");
		this.serviceCode = serviceCode;
	}

	public void addAccount(Account theAccount , boolean vipFlag) {
		
		System.out.println(getClass() + " Doing my DB work : adding an account ");
		
	}
	
	public boolean doWork() {
		
		System.out.println(getClass() + " : Do Work ");
		return false;
	}

}
