package com.cognizant.beans;

public class Bean4 {

	public Bean4() {
		System.out.println("--Bean4 Constructor");
	}
	
	
	public void initMethod() {
		System.out.println("--init Method--");
	}
	
	//before IOC Container shuts down
	//destroy method is called
	
	public void destroyMethod() {
		System.out.println("--destroy method--");
	}
}
