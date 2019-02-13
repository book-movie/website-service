package com.cg.bookmymovie.screeningservice.entity;

public class Address {

	private String state;
	private String city;
	private String area;
	
	public Address() {
		
	}
	
	public Address(String state, String city, String area) {
		super();
		this.state = state;
		this.city = city;
		this.area = area;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}


	@Override
	public String toString() {
		return "Address [state=" + state + ", city=" + city + ", area=" + area + "]";
	}

	
}
