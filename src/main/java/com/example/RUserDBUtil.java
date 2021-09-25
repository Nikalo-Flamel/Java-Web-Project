package com.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RUserDBUtil {
	
	private static MovieDBUtil MovieDBUtil = new MovieDBUtil();
	

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

	public User getUserbyUserName(String userName) throws Exception{
		
		User user = null;
		
		Connection myConn = null;
		PreparedStatement myStmt= null;
		ResultSet myRe = null;
		
		try {
			
			//get the connection
			myConn = DBConnect.getConnection();
			
			//create sql statement
			String sql = "select * from RegisteredUser where user_name=?";
			myStmt = myConn.prepareStatement(sql);
			myStmt.setString(1, userName);
			
			//execute query
			myRe = myStmt.executeQuery();
			
			//process the result set
			if (myRe.next()) {
				//retrieve data
				int id = myRe.getInt("RegisteredUserId");
				String password = myRe.getString("password");
				String email = myRe.getString("email");
				
				System.out.println(userName);
				
				//create new student
				user = new RegisteredUser(id, userName, password, email);

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
			myConn = DBConnect.getConnection();
			
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
				String password = myRe.getString("password");
				String email = myRe.getString("email");
				//System.out.println(userName);
				
				//create new student
				user = new RegisteredUser(id, userName, password, email);
				
				user.setWishedMovies(getWishedMovies(userId));

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

	private List<Movie> getWishedMovies(String userId) throws Exception{
		
		List<Movie> wishedMovies = new ArrayList<Movie>();
		
		Connection myConn = null;
		PreparedStatement myStmt= null;
		ResultSet myRe = null;
		int id;
		
		try {
			id = Integer.parseInt(userId);
			
			//get the connection
			myConn = DBConnect.getConnection();
			
			//create sql statement
			String sql = "select * from WishedMovies where RegisteredUserId=?";
			myStmt = myConn.prepareStatement(sql);
			myStmt.setInt(1, id);

			//execute query
			myRe = myStmt.executeQuery();
			
			//process the result set
			while (myRe.next()) {
				//retrieve data
				int movieId = myRe.getInt("MovieId");
				wishedMovies.add(MovieDBUtil.getMovie(movieId));	
			}	
			
			return wishedMovies;
			
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
			myConn = DBConnect.getConnection();
			
			//create sql statement
			String sql = "update RegisteredUser "
					+ "set user_name=?, password=?, email=? "
					+ "where RegisteredUserId=?";
			
			myStmt = myConn.prepareStatement(sql);
			myStmt.setString(1, user.getUserName());
			myStmt.setString(2, user.getPassword());
			myStmt.setString(3, user.getEmail());
			myStmt.setInt(4, user.getId());
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
			myConn = DBConnect.getConnection();
			
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
