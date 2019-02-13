package com.cg.bookmymovie.screeningservice.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;



public class Screening {

	private int id;
	private String movieName;
	private LocalTime movieDuration;
	private String movieType;
	private String movieLanguage;
	private String moviePoster;
	private String theatreName;
	private Address theatreAddress;
	private String auditoriumName;

	private LocalTime startTime;
	
	private LocalDate date;
	
	private Map<String, Double> price;
	private boolean showing;
	
	public Screening() {
		
	}

	public Screening(String movieName, LocalTime movieDuration, String movieType, String movieLanguage,
			String moviePoster, String theatreName, Address theatreAddress, String auditoriumName, LocalTime startTime,
			LocalDate date, Map<String, Double> price, boolean showing) {
		super();
		this.movieName = movieName;
		this.movieDuration = movieDuration;
		this.movieType = movieType;
		this.movieLanguage = movieLanguage;
		this.moviePoster = moviePoster;
		this.theatreName = theatreName;
		this.theatreAddress = theatreAddress;
		this.auditoriumName = auditoriumName;
		this.startTime = startTime;
		this.date = date;
		this.price = price;
		this.showing = showing;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public LocalTime getMovieDuration() {
		return movieDuration;
	}

	public void setMovieDuration(LocalTime movieDuration) {
		this.movieDuration = movieDuration;
	}

	public String getMovieType() {
		return movieType;
	}

	public void setMovieType(String movieType) {
		this.movieType = movieType;
	}

	public String getMovieLanguage() {
		return movieLanguage;
	}

	public void setMovieLanguage(String movieLanguage) {
		this.movieLanguage = movieLanguage;
	}

	public String getMoviePoster() {
		return moviePoster;
	}

	public void setMoviePoster(String moviePoster) {
		this.moviePoster = moviePoster;
	}

	public String getTheatreName() {
		return theatreName;
	}

	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}

	public Address getTheatreAddress() {
		return theatreAddress;
	}

	public void setTheatreAddress(Address theatreAddress) {
		this.theatreAddress = theatreAddress;
	}

	public String getAuditoriumName() {
		return auditoriumName;
	}

	public void setAuditoriumName(String auditoriumName) {
		this.auditoriumName = auditoriumName;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Map<String, Double> getPrice() {
		return price;
	}

	public void setPrice(Map<String, Double> price) {
		this.price = price;
	}

	public boolean isShowing() {
		return showing;
	}

	public void setShowing(boolean showing) {
		this.showing = showing;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((movieName == null) ? 0 : movieName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Screening other = (Screening) obj;
		if (movieName == null) {
			if (other.movieName != null)
				return false;
		} else if (!movieName.equals(other.movieName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Screening [id=" + id + ", movieName=" + movieName + ", movieDuration=" + movieDuration + ", movieType="
				+ movieType + ", movieLanguage=" + movieLanguage + ", moviePoster=" + moviePoster + ", theatreName="
				+ theatreName + ", theatreAddress=" + theatreAddress + ", auditoriumName=" + auditoriumName
				+ ", startTime=" + startTime + ", date=" + date + ", price=" + price + ", showing=" + showing + "]";
	}

	


}
