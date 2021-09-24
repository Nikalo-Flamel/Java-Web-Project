package com.example;

import java.util.List;
import java.util.ArrayList;

public class RegisteredUser extends User{
	
	private int id;
	private String userName;
	private String password;
	private String email;
	private List<Movie> wishedMovies;
	private List<TVSeries> watchedTVSeries;
	
	public RegisteredUser(int id, String userName, String password, String email) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.wishedMovies = new ArrayList<Movie>();
		this.watchedTVSeries = new ArrayList<TVSeries>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Movie> getWishedMovies() {
		return wishedMovies;
	}

	public void setWishedMovies(List<Movie> wishedMovies) {
		this.wishedMovies = wishedMovies;
	}

	public List<TVSeries> getWatchedTVSeries() {
		return watchedTVSeries;
	}

	public void setWatchedTVSeries(List<TVSeries> watchedTVSeries) {
		this.watchedTVSeries = watchedTVSeries;
	}
	
}
