package com.jforce.dto;

import java.io.Serializable;

public class SearchRoomDTO implements Serializable {
	private String checkInDate;
	private String checkOutDate;

	public String getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(String checkInDate) {
		this.checkInDate = checkInDate;
	}

	public String getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

}
