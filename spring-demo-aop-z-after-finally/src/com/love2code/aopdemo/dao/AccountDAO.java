package com.love2code.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

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
	
	public List<Account> findAccounts(boolean tripWire) {
		
		
		if(tripWire) {
			throw new RuntimeException("No Soup for you ");
		}
		
		List<Account> myAccounts = new ArrayList<>(); 
		
		Account tempAccount1 = new Account("Dantesh","Gold");
		Account tempAccount2 = new Account("Luka","Silver");
		Account tempAccount3 = new Account("David","Gold");
		
		myAccounts.add(tempAccount1);
		myAccounts.add(tempAccount2);
		myAccounts.add(tempAccount3);
		
		return myAccounts;
		
	}

}
