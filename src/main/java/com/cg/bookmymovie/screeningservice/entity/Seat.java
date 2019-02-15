package com.cg.bookmymovie.screeningservice.entity;

public class Seat {
	private String seatType;
	private char seatRow;
	private int column;
	private boolean available;
	private double price;

	public Seat() {
	}

	public Seat(String seatType, char seatRow, int column, boolean available, double price) {
		super();
		this.seatType = seatType;
		this.seatRow = seatRow;
		this.column = column;
		this.available = available;
		this.price = price;
	}

	public String getSeatType() {
		return seatType;
	}

	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}

	public char getSeatRow() {
		return seatRow;
	}

	public void setSeatRow(char seatRow) {
		this.seatRow = seatRow;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Seat [seatType=" + seatType + ", seatRow=" + seatRow + ", column=" + column + ", available=" + available
				+ ", price=" + price + "]";
	}

	
}
