package com.cinema.enitity;

import java.io.Serializable;
import java.util.List;
/**
 * ���������Ǳ�ʾ��ӳ�ճ���
 * @author Administrator
 *
 */
public class Schedule implements Serializable{
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((items == null) ? 0 : items.hashCode());
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
		Schedule other = (Schedule) obj;
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
		return true;
	}
	private final long seriaVersionUID=0;
	private List<ScheduleItem> items;
	public Schedule() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Schedule(List<ScheduleItem> items) {
		super();
		this.items = items;
	}
	public List<ScheduleItem> getItems() {
		return items;
	}
	public void setItems(List<ScheduleItem> items) {
		this.items = items;
	}
	public long getSeriaVersionUID() {
		return seriaVersionUID;
	}
	public void loadItems(ScheduleItem item) {
		items.add(item);
	}
	public  void printMovie() {
		System.out.println("���\t��Ӱ����\t\tӢ������\t\t����\t����\t\t����\tȫƱ�۸�\tʱ��");
		for(int i=0;i<items.size();i++) {
			Movie movie=items.get(i).getMovie();
			System.out.print((i+1)+"\t"+movie.getMovieName()+"\t"+movie.getPoster()+"\t"
			+movie.getList().get(0).getName()+"\t");
			movie.printActors();
			System.out.print("\t"+movie.getMovieType()+"\t��"+movie.getPrice()+"\t"+items.get(i).getTime());
			System.out.println();
		}
	}
}

