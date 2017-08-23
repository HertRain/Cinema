package com.cinema.enitity;

import java.io.Serializable;

public class Seat implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String seatNum;
	public Seat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Seat(String seatNum) {
		super();
		this.seatNum = seatNum;
	}
	public String getSeatNum() {
		return seatNum;
	}
	public void setSeatNum(String seatNum) {
		this.seatNum = seatNum;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((seatNum == null) ? 0 : seatNum.hashCode());
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
		Seat other = (Seat) obj;
		if (seatNum == null) {
			if (other.seatNum != null)
				return false;
		} else if (!seatNum.equals(other.seatNum))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Seat [seatNum=" + seatNum + "]";
	}
	
}
