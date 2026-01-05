package com.foodapp.model;

public class Restaurant {
	private int id;
	private String name;
	private String location;
	private double rating;
	private String image;
	private String cuisineType;

	public Restaurant() {
		super();
	}

	public Restaurant(int id, String name, String location, double rating, String image, String cuisineType) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.rating = rating;
		this.image = image;
		this.cuisineType = cuisineType;
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCuisineType() {
		return cuisineType;
	}

	public void setCuisineType(String cuisineType) {
		this.cuisineType = cuisineType;
	}

}
