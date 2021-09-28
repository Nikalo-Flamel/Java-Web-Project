package com.example;

import java.util.List;
import java.util.ArrayList;

public class RegisteredUser extends User{
	
	private int id;
	//private List<Movie> wishedMovies;
	//private List<TVSeries> watchedTVSeries;
	
	public RegisteredUser(String username, String name, String password, String email, String mobile, int id) {
		super(username, name, password, email, mobile);
		this.id = id;
		//this.watchedTVSeries = new ArrayList<TVSeries>();
	}
	
	public RegisteredUser(String username, String name, String password, String email, String mobile) {
		super(username, name, password, email, mobile);
		this.id = 0;
		//this.watchedTVSeries = new ArrayList<TVSeries>();
	}
	
	public int getId() {
		return this.id;
	}

//	public List<Movie> getWishedMovies() {
//		return wishedMovies;
//	}
//
//	public void setWishedMovies(List<Movie> wishedMovies) {
//		this.wishedMovies = wishedMovies;
//	}
//
//	public List<TVSeries> getWatchedTVSeries() {
//		return watchedTVSeries;
//	}
//
//	public void setWatchedTVSeries(List<TVSeries> watchedTVSeries) {
//		this.watchedTVSeries = watchedTVSeries;
//	}
	
}
