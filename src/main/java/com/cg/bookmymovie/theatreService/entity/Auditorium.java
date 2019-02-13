package com.cg.bookmymovie.theatreService.entity;

import java.util.Map;

public class Auditorium {
	private String auditoriumName;
	private Map<Integer, Seat> seat;

	public Auditorium() {
		super();
	}

	public Auditorium(String auditoriumName, Map<Integer, Seat> seat) {
		super();
		this.auditoriumName = auditoriumName;
		this.seat = seat;
	}

	public String getAuditoriumName() {
		return auditoriumName;
	}

	public void setAuditoriumName(String auditoriumName) {
		this.auditoriumName = auditoriumName;
	}

	public Map<Integer, Seat> getSeat() {
		return seat;
	}

	public void setSeat(Map<Integer, Seat> seat) {
		this.seat = seat;
	}

	@Override
	public String toString() {
		return "Auditorium [auditoriumName=" + auditoriumName + ", seat=" + seat + "]";
	}

	
}
