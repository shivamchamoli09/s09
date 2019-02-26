package com.cognizant.dao;

import com.cognizant.helper.Status;

public interface CustomerDAO {
 public	Status authCustomer(String userName,String password,int attempt);
}
