package com.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.test.ConnectDb.DbConnect;
import com.test.LoginBean.TestLogin;

public class LoginRepository {

	public boolean validateLogin(TestLogin login) {
		boolean check = false ;
		Connection connect = DbConnect.getDbConnect();
		String query = "select * from login where username=?";
		
		try {
			PreparedStatement pst = connect.prepareStatement(query);
			pst.setString(1, login.getUsername());
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				String db_username = rs.getString(1);
				String db_password = rs.getString(2);
				if(login.getUsername().equals(db_username)) {
					System.out.println("Username found !");
					if(login.getPassword().equals(db_password)) {
						check = true;
					}
					else {
						check = false;
					}
				}
			}
			else {
				System.out.println("Username not found !");
				check = false;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return check;
	}
}
