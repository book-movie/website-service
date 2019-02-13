package com.cg.bookmymovie.movie.movie.entity;

import java.time.LocalDate;

public class Crew {

	private String name;
	private String bio;
	private String role;
	private String photo;
	private LocalDate date;
	public Crew() {
		super();
	
	}
	public Crew(String name, String bio, String role, String photo, LocalDate date) {
		super();
		this.name = name;
		this.bio = bio;
		this.role = role;
		this.photo = photo;
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	

}
