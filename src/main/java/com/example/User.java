package com.example;

public class User {
	
	private String Username;
	private String Name;
	private String Password;
	private String Email;
	private String Mobile;
	
	public User(String username, String name, String password, String email, String mobile) {
		Username = username;
		Name = name;
		Password = password;
		Email = email;
		Mobile = mobile;
	}
	
	public String getUsername() {
		return Username;
	}
	
	public String getName() {
		return Name;
	}
	
	public String getPassword() {
		return Password;
	}
	
	public String getEmail() {
		return Email;
	}
	
	public String getMobile() {
		return Mobile;
	}

}