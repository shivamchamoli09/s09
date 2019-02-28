package com.cognizant.demo;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.cognizant.beans.Bean1;
import com.cognizant.beans.Bean2;
import com.cognizant.beans.Bean3;
import com.cognizant.beans.Bean4;
import com.cognizant.beans.Bean5;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Tightly Coupled Code
		Bean1 bean1=new Bean1();
		bean1.x();
		
		//Loosely Coupled Code
		
		Resource resource= new ClassPathResource("applicationContext.xml");
		
		//Pure IOC Container - Bean Factory
		//Usage of Bean Factory is limited to creating instance of Spring bean based on configuration information in XML
		
		BeanFactory ioc1=new XmlBeanFactory(resource);
		
		Bean1 bean11=(Bean1)ioc1.getBean("bean1");
		bean11.x();
		
		
		//Application Context is superset of bean factory apart from Dependency Injection 
        //provides services for validation, internationalization, email, etc.
		
		ApplicationContext ioc2= new ClassPathXmlApplicationContext("applicationContext.xml");
		Bean1 bean12=(Bean1)ioc2.getBean("bean1");
		bean12.x();
		
		Bean1 bean13=(Bean1)ioc2.getBean("bean1");
		
		
		if(bean12==bean13)
			System.out.println("Singleton Design Pattern");
		//By Default Singleton bean are eagerly loaded
		
		
		
		Bean2 bean2=(Bean2)ioc2.getBean("bean2");
		
		//Prototype Bean
		Bean3 bean31=(Bean3)ioc2.getBean("bean3");
		Bean3 bean32=(Bean3)ioc2.getBean("bean3");
		
		if(bean31 != bean32)
			System.out.println("bean 31 is not equal to bean32");
		
//Multiple configuration files in class path
//Assume applicationContext.xml, applicationContext2.xml
		
//ApplicationContext ioc2= new ClassPathXmlApplicationContext(new String [] {"applicationContext.xml, applicationContext2.xml});
           
		//Configuration file outside classpath
		
	// ApplicationContext ioc3=	new FileSystemXmlApplicationContext("beans.xml");
	// Bean3 bean3=(Bean3)ioc3.getBean("bean3");
	
		//Bean4 
		AbstractApplicationContext ioc4= new ClassPathXmlApplicationContext("applicationContext.xml");
		Bean4 bean4=(Bean4)ioc4.getBean("bean4");
		ioc4.registerShutdownHook();
		
		ApplicationContext ioc5=new ClassPathXmlApplicationContext("applicationContext.xml");
		Bean5 bean5=(Bean5)ioc5.getBean("bean5");
		
		
	}}
