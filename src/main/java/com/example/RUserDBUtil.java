package com.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RUserDBUtil {
	
	//private static MovieDBUtil MovieDBUtil = new MovieDBUtil();
	

	public boolean validateUser(User user, String password){
		
		if (user == null) {
			return false;
		}
		if (user.getPassword().equals(password)) {
			//System.out.println("Equal");
			return true;
		} else {
			return false;
		}
	}
	
	public int RegisterUser(RegisteredUser user) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt= null;
		int isSuccess = -1;
		
		try {
			//get the connection
			myConn = DBconnect.getConnection();
			
			//create sql statement
			String sql = "insert into RegisteredUser value (0, ?, ?, ?, ?, ? ) ";
			
			myStmt = myConn.prepareStatement(sql);
			myStmt.setString(1, user.getUsername());
			myStmt.setString(2, user.getName());
			myStmt.setString(3, user.getPassword());
			myStmt.setString(4, user.getEmail());
			myStmt.setString(5, user.getMobile());
			//System.out.println(myStmt);

			//execute query
			isSuccess = myStmt.executeUpdate();
			System.out.println("Updated");
			System.out.println(isSuccess);
		}
		finally {
			
			//close jdbc objects
			close(myConn, myStmt, null);
		}

		return isSuccess;
	}

	public RegisteredUser getUserbyUserName(String userName) throws Exception{
		
		RegisteredUser user = null;
		
		Connection myConn = null;
		PreparedStatement myStmt= null;
		ResultSet myRe = null;
		
		try {
			
			//get the connection
			myConn = DBconnect.getConnection();
			
			//create sql statement
			String sql = "select * from RegisteredUser where User_name=?";
			myStmt = myConn.prepareStatement(sql);
			myStmt.setString(1, userName);
			
			//execute query
			myRe = myStmt.executeQuery();
			
			//process the result set
			if (myRe.next()) {
				//retrieve data
				int id = myRe.getInt("RegisteredUserId");
				String name = myRe.getString("Name");
				String password = myRe.getString("password");
				String email = myRe.getString("Email");
				String mobile = myRe.getString("Mobile");
				
				System.out.println(userName);
				
				//create new student
				user = new RegisteredUser(userName, name, password, email, mobile, id);

			} else {
				//throw new Exception("Could not find student user name: " + userName);
				user = null;
			}
			
			return user;
		}
		finally {
			
			//close jdbc objects
			close(myConn, myStmt, myRe);
		}
	}

	public RegisteredUser getRegisteredUser(String userId) throws Exception{
		
		RegisteredUser user = null;
		
		Connection myConn = null;
		PreparedStatement myStmt= null;
		ResultSet myRe = null;
		int id;
		
		try {
			id = Integer.parseInt(userId);
			//System.out.println(id);
			
			//get the connection
			myConn = DBconnect.getConnection();
			
			//create sql statement
			String sql = "select * from RegisteredUser where RegisteredUserId=?";
			myStmt = myConn.prepareStatement(sql);
			myStmt.setInt(1, id);
			
			//execute query
			myRe = myStmt.executeQuery();
			
			//process the result set
			if (myRe.next()) {
				//retrieve data
				String userName = myRe.getString("user_name");
				String name = myRe.getString("Name");
				String password = myRe.getString("password");
				String email = myRe.getString("Email");
				String mobile = myRe.getString("Mobile");
				//System.out.println(userName);
				
				//create new student
				user = new RegisteredUser(userName, name, password, email, mobile, id);
				
				//user.setWishedMovies(getWishedMovies(userId));

			} else {
				throw new Exception("Could not find student id: " + userId);
			}
			
			return user;
		}
		finally {
			
			//close jdbc objects
			close(myConn, myStmt, myRe);
		}
	}

	

	public boolean updateRegisteredUser(RegisteredUser user) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt= null;
		boolean isSuccess = false;
		
		try {
			//get the connection
			myConn = DBconnect.getConnection();
			
			//create sql statement
			String sql = "update RegisteredUser "
					+ "set User_name=?, Name=?, Password=?, Email=?, Mobile=? "
					+ "where RegisteredUserId=?";
			
			myStmt = myConn.prepareStatement(sql);
			myStmt.setString(1, user.getUsername());
			myStmt.setString(2, user.getName());
			myStmt.setString(3, user.getPassword());
			myStmt.setString(4, user.getEmail());
			myStmt.setString(5, user.getMobile());
			myStmt.setInt(6, user.getId());
			//System.out.println(myStmt);

			//execute query
			isSuccess = myStmt.execute();
			//System.out.println("Updated");
		}
		finally {
			
			//close jdbc objects
			close(myConn, myStmt, null);
		}

		return isSuccess;
	}
	

	public boolean deleteUser(RegisteredUser user) throws Exception{
		
		Connection myConn = null;
		PreparedStatement myStmt= null;
		boolean isSuccess = false;
		
		try {
			//get the connection
			myConn = DBconnect.getConnection();
			
			//create sql statement
			String sql = "delete from RegisteredUser where RegisteredUserId=?";
			
			myStmt = myConn.prepareStatement(sql);
			myStmt.setInt(1, user.getId());
			//System.out.println(myStmt);

			//execute query
			isSuccess = myStmt.execute();
			//System.out.println("Updated");
		}
		finally {
			
			//close jdbc objects
			close(myConn, myStmt, null);
		}

		return isSuccess;
	}
	
	private void close(Connection myConn, Statement myStmt, ResultSet myRe) {
		
		try {
			if (myRe != null) {
				myRe.close();
			}		
			if (myStmt != null) {
				myStmt.close();
			}			
			if (myConn != null) {
				myConn.close();
			}
		}
		catch (Exception exc){
			exc.printStackTrace();
		}
	}

}
