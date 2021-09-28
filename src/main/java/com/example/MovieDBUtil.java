package com.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class MovieDBUtil {
	
	public Movie getMovie(int movieId) throws Exception {
		
		Movie movie = null;
		
		Connection myConn = null;
		PreparedStatement myStmt= null;
		ResultSet myRe = null;
		int id;
		
		try {
			id = movieId;
			//System.out.println(id);
			
			//get the connection
			myConn = DBconnect.getConnection();
			
			//create sql statement
			String sql = "select * from Movie where MovieId=?";
			myStmt = myConn.prepareStatement(sql);
			myStmt.setInt(1, id);
			
			//execute query
			myRe = myStmt.executeQuery();
			
			//process the result set
			if (myRe.next()) {
				//retrieve data
				String name = myRe.getString("name");
				String language = myRe.getString("language");
				String url = myRe.getString("url");
				String thumbnail = myRe.getString("image");
				//System.out.println(userName);
				
				//create new student
				movie = new Movie(id, name, language, url, thumbnail);
				

			} else {
				throw new Exception("Could not find movie id: " + movieId);
			}
			
			return movie;
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
