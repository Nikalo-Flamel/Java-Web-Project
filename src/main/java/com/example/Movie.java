package com.example;

public class Movie {
	
	private int id;
	private String name;
	private String discription;
	private String url;
	private String thumbnail;
	
	public Movie(int id, String name, String discription, String url, String thumbnail) {
		this.id = id;
		this.name = name;
		this.discription = discription;
		this.url = url;
		this.thumbnail = thumbnail;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	
}
