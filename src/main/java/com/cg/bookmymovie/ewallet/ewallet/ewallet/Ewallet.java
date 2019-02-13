package com.cg.bookmymovie.ewallet.ewallet.ewallet;

import java.util.Set;

public class Ewallet {

	private Integer profileId;
	private Double currentBalance;

	private Set<Statement> statement;

	public Integer getProfileId() {
		return profileId;
	}

	public void setProfileId(Integer profileId) {
		this.profileId = profileId;
	}

	public Double getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(Double currentBalance) {
		this.currentBalance = currentBalance;
	}

	public Set<Statement> getStatement() {
		return statement;
	}

	public void setStatement(Set<Statement> statement) {
		this.statement = statement;
	}

	public Ewallet(Double currentBalance, Set<Statement> statement) {
		super();
		this.currentBalance = currentBalance;
		this.statement = statement;
	}

	public Ewallet() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Ewallet [profileId=" + profileId + ", currentBalance=" + currentBalance + ", statement=" + statement
				+ "]";
	}

}
