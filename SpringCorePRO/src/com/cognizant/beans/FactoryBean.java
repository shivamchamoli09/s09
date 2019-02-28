package com.cognizant.beans;

public class FactoryBean {
	
	public FactoryBean() {
		System.out.println("--FactoryBean--");
	}
	
	public  Bean5 createInstanceBean5() {
	
		System.out.println("--createInstanceBean5 method called--");
		
	Bean5 bean5=new Bean5();
	return bean5;
	}
}
