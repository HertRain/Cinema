package com.cinema.datadao;

import java.util.List;

import com.cinema.enitity.Movie;
import com.cinema.enitity.Schedule;
import com.cinema.enitity.ScheduleItem;

public interface MovieDao {
	/**
	 * 从xml文件中获取所有要放映的电影
	 * @param 无
	 * @return List<Movie>
	 */
	public abstract Schedule getAllMovie();

}
