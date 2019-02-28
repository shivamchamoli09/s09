package com.cognizant.di;

public class DependencyInjection {
	
	public static void main() {
		
		ConnectionManager manager=new ConnectionManager();
		manager.openConnection();
		
	}

}
