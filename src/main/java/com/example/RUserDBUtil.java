package com.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RUserDBUtil {

	public RegisteredUser getRegisteredUser(String userId)
	throws Exception{
		
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
				
				//user.setWatchedMovies(getWatchedMovies(userId));

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

	private List<Movie> getWatchedMovies(String userId) throws Exception{
		
		List<Movie> watchedMovies = new ArrayList<Movie>();
		
		Connection myConn = null;
		PreparedStatement myStmt= null;
		ResultSet myRe = null;
		int id;
		
		try {
			id = Integer.parseInt(userId);
			
			//get the connection
			myConn = DBConnect.getConnection();
			
			//create sql statement
			String sql = "select * from WatchedMovies where RegisteredUserId=?";
			myStmt = myConn.prepareStatement(sql);
			myStmt.setInt(1, id);

			//execute query
			myRe = myStmt.executeQuery();
			
			//process the result set
			while (myRe.next()) {
				//retrieve data
				int movieId = myRe.getInt("MovieId");
				
			}	
			
			return watchedMovies;
			
		}
		finally {
			
			//close jdbc objects
			close(myConn, myStmt, myRe);
		}
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
