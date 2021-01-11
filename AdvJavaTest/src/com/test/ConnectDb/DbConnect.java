package com.test.ConnectDb;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnect {

	public static Connection getDbConnect() {
		String driverClassName = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/test";
		String dbUsername = "root";
		String dbPassword = "Mysql30";
		Connection con = null;
		try {
			Class.forName(driverClassName);
			con = DriverManager.getConnection(url, dbUsername, dbPassword);
		}
		catch(Exception e){
			System.out.println("Exception Occured in connection : "+e);
		}
		return con;
	}
}
