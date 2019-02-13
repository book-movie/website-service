package com.cg.bookmymovie.theatreService.entity;

import java.util.Set;


public class Theatre {
	private int theatreId;
	private String theatreName;
	private Address theatreAddress;
	private Set<Auditorium> auditorium;

	public Theatre() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Theatre(int theatreId, String theatreName, Address theatreAddress, Set<Auditorium> auditorium) {
		super();
		this.theatreId = theatreId;
		this.theatreName = theatreName;
		this.theatreAddress = theatreAddress;
		this.auditorium = auditorium;
	}

	public int getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(int theatreId) {
		this.theatreId = theatreId;
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

	public Set<Auditorium> getAuditorium() {
		return auditorium;
	}

	public void setAuditorium(Set<Auditorium> auditorium) {
		this.auditorium = auditorium;
	}

	@Override
	public String toString() {
		return "Theatre [theatreId=" + theatreId + ", theatreName=" + theatreName + ", theatreAddress=" + theatreAddress
				+ ", auditorium=" + auditorium + "]";
	}

	public boolean isPresent() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((auditorium == null) ? 0 : auditorium.hashCode());
		result = prime * result + ((theatreAddress == null) ? 0 : theatreAddress.hashCode());
		result = prime * result + theatreId;
		result = prime * result + ((theatreName == null) ? 0 : theatreName.hashCode());
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
		Theatre other = (Theatre) obj;
		if (auditorium == null) {
			if (other.auditorium != null)
				return false;
		} else if (!auditorium.equals(other.auditorium))
			return false;
		if (theatreAddress == null) {
			if (other.theatreAddress != null)
				return false;
		} else if (!theatreAddress.equals(other.theatreAddress))
			return false;
		if (theatreId != other.theatreId)
			return false;
		if (theatreName == null) {
			if (other.theatreName != null)
				return false;
		} else if (!theatreName.equals(other.theatreName))
			return false;
		return true;
	}

	
	
	
}
