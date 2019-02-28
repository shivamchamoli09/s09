package com.cognizant.di;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JDBCProductsDAOImpl {
	
	ApplicationContext ioc=null;
	public JDBCProductsDAOImpl() {
		ioc=new ClassPathXmlApplicationContext("applicationContext.xml");
		
	}
	
	public List getProducts() {
		ConnectionManager manager=new ConnectionManager();
		Connection con=manager.openConnection();
		ProductsQuery query= (ProductsQuery)ioc.getBean("productsquery");
				
				try {
				con.prepareStatement(query.getSelectProduct());
				}catch(SQLException e)
		{
					e.printStackTrace();
		}
		
				return null;
	}

}
