package com.cognizant.helper;

import com.cognizant.dao.CustomerDAO;
import com.cognizant.dao.JDBCCustomerDAOImpl;


public class FactoryCustomerDAO {
	public static CustomerDAO createCustomerDAO(){
		CustomerDAO customerDAO = new JDBCCustomerDAOImpl();
		return customerDAO;
	}
}
