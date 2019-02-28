package com.cognizant.beans;

public class Bean5 {
 
	public Bean5() {
		System.out.println("--Bean5 Constructor--");
	}

	public static Bean5 createInstance() {
		
		System.out.println("--createInstance method called--");
		
		Bean5 bean5 = new Bean5();
		return bean5;
	}
}
