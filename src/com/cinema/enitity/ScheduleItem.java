package com.cinema.enitity;

import java.io.Serializable;
import java.util.List;
/**
 * 放映场次类
 * @author Administrator
 *
 */
public class ScheduleItem implements Serializable{
	private final long seriaVersionUID=0;
	private String time;
	private Movie movie;
	public ScheduleItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ScheduleItem(String time, Movie movie) {
		super();
		this.time = time;
		this.movie = movie;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public long getSeriaVersionUID() {
		return seriaVersionUID;
	}
	@Override
	public String toString() {
		return "ScheduleItem [time=" + time + ", movie=" + movie + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((movie == null) ? 0 : movie.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
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
		ScheduleItem other = (ScheduleItem) obj;
		if (movie == null) {
			if (other.movie != null)
				return false;
		} else if (!movie.equals(other.movie))
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		return true;
	}
	
	
}
