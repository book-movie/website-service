package com.cg.bookmymovie.screeningservice.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;


public class Screening {

	private int id;

//	private static int number=2;
	
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
	private boolean showing;
	private Map<Integer, Seat> seat;
	
	
	public Screening() {
		
	}

	public Screening(int id, String movieName, LocalTime movieDuration, String movieType, String movieLanguage,
			String moviePoster, String theatreName, Address theatreAddress, String auditoriumName, LocalTime startTime,
			LocalDate date, boolean showing, Map<Integer, com.cg.bookmymovie.screeningservice.entity.Seat> seat) {
		super();
		this.id = id;
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
		this.showing = showing;
		this.seat = seat;
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

	public boolean isShowing() {
		return showing;
	}

	public void setShowing(boolean showing) {
		this.showing = showing;
	}

	public Map<Integer, Seat> getSeat() {
		return seat;
	}

	public void setSeat(Map<Integer, Seat> seat) {
		this.seat = seat;
	}

	@Override
	public String toString() {
		return "Screening [id=" + id + ", movieName=" + movieName + ", movieDuration=" + movieDuration + ", movieType="
				+ movieType + ", movieLanguage=" + movieLanguage + ", moviePoster=" + moviePoster + ", theatreName="
				+ theatreName + ", theatreAddress=" + theatreAddress + ", auditoriumName=" + auditoriumName
				+ ", startTime=" + startTime + ", date=" + date + ", showing=" + showing + ", seat=" + seat + "]";
	}


	

}
