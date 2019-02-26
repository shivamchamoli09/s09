package com.cognizant.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cognizant.helper.ConnectionManager;
import com.cognizant.helper.Status;

public class JDBCCustomerDAOImpl implements CustomerDAO {
	private ConnectionManager manager= new ConnectionManager();
	boolean flag=false;
	Status  status=Status.DENY;
	@Override
	public Status authCustomer(String userName,String password,int attempt) {
		if(attempt>3){
			status=Status.LOCK;
			return status;
		}
		Connection connection =manager.openConnection();
		
		try{
			PreparedStatement stmt = connection.prepareStatement("select * from LOGIN_DETAILS where LOGIN_ID=? and LOGIN_PIN=?");
			stmt.setString(1,userName);
			stmt.setString(2,password);
			ResultSet set= stmt.executeQuery();
			flag=set.next();
			if(!flag){
				if(attempt==2){
					status=Status.LOCK;
					PreparedStatement stmt2=connection.prepareStatement("UPDATE LOGIN_DETAILS set STATUS='LOCK' where LOGIN_ID=?");
					stmt2.setString(1,userName);
					stmt2.executeUpdate();
				}
				else{
					status=Status.DENY;
				}
			}
			else{
				String st=set.getString("STATUS");
				if(st.equals("LOCK")){
					status=Status.LOCK;
				}
				else{
					status=Status.ACCEPT;
				}
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		manager.closeConnection();
		return status;
	}

}
