package com.cognizant.beans;

//Infrastructure Services eg. Security, Tracing, Debugging, Performance Monitoring, Persistence,
// DataBase Operations etc.
	
//Spring bean is infrastructure service class which provides above mentioned infrastructure services.
	
//Spring Bean Object life cycle are managed by IOC Container(Loosely Coupled Container)
	
//Information (configuration) required to manage life cycle of spring bean must be provided
//either using XML or annotations.


public class Bean1 {
	
	
	//Method provides some infrastructure services
	public void x() {
		System.out.println("x called");
	}
	
}
