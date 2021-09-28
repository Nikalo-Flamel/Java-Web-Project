package com.example;


import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnect {
	
	//jdbc:mysql://localhost:3306/`oop_demo1`
	
	private static String url = "jdbc:mysql://localhost:3306/oop_demo1";
	private static String userName = "root";
	private static String password = "301199";
	private static Connection con;

	public static Connection getConnection() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection(url, userName, password);
			
		}
		catch (Exception e) {
			System.out.println("Database connection is not success!!!");
			e.printStackTrace();
		}
		
		return con;
	}
}