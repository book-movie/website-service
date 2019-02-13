package com.cg.bookmymovie.movie.movie.entity;

public class RunningTime {

	private Integer hours;
	private Integer minutes;

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	@Override
	public String toString() {
		return "RunningTime [hours=" + hours + ", minutes=" + minutes + "]";
	}

	public RunningTime(Integer hours, Integer minutes) {
		super();
		this.hours = hours;
		this.minutes = minutes;
	}

	public RunningTime() {
		super();
	}

}
