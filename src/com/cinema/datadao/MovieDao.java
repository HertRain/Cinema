package com.cinema.datadao;

import java.util.List;

import com.cinema.enitity.Movie;
import com.cinema.enitity.Schedule;
import com.cinema.enitity.ScheduleItem;

public interface MovieDao {
	/**
	 * ��xml�ļ��л�ȡ����Ҫ��ӳ�ĵ�Ӱ
	 * @param ��
	 * @return List<Movie>
	 */
	public abstract Schedule getAllMovie();

}
