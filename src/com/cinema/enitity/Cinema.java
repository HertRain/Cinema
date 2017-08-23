package com.cinema.enitity;

import java.io.Serializable;
import java.util.List;

public class Cinema implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Ticket> soldTickets;
	private Schedule schedule;
	private ScheduleItem scheduleItem;
	private Seat seats;
	public Cinema() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cinema(List<Ticket> soldTickets, Schedule schedule, ScheduleItem scheduleItem, Seat seats) {
		super();
		this.soldTickets = soldTickets;
		this.schedule = schedule;
		this.scheduleItem = scheduleItem;
		this.seats = seats;
	}
	public List<Ticket> getSoldTickets() {
		return soldTickets;
	}
	public void setSoldTickets(List<Ticket> soldTickets) {
		this.soldTickets = soldTickets;
	}
	public Schedule getSchedule() {
		return schedule;
	}
	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}
	public ScheduleItem getScheduleItem() {
		return scheduleItem;
	}
	public void setScheduleItem(ScheduleItem scheduleItem) {
		this.scheduleItem = scheduleItem;
	}
	public Seat getSeats() {
		return seats;
	}
	public void setSeats(Seat seats) {
		this.seats = seats;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((schedule == null) ? 0 : schedule.hashCode());
		result = prime * result + ((scheduleItem == null) ? 0 : scheduleItem.hashCode());
		result = prime * result + ((seats == null) ? 0 : seats.hashCode());
		result = prime * result + ((soldTickets == null) ? 0 : soldTickets.hashCode());
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
		Cinema other = (Cinema) obj;
		if (schedule == null) {
			if (other.schedule != null)
				return false;
		} else if (!schedule.equals(other.schedule))
			return false;
		if (scheduleItem == null) {
			if (other.scheduleItem != null)
				return false;
		} else if (!scheduleItem.equals(other.scheduleItem))
			return false;
		if (seats == null) {
			if (other.seats != null)
				return false;
		} else if (!seats.equals(other.seats))
			return false;
		if (soldTickets == null) {
			if (other.soldTickets != null)
				return false;
		} else if (!soldTickets.equals(other.soldTickets))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Cinema [soldTickets=" + soldTickets + ", schedule=" + schedule + ", scheduleItem=" + scheduleItem
				+ ", seats=" + seats + "]";
	}
	public void save() {}
	public void Load() {}

}
