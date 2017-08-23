package com.cinema.enitity;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
/**
 * 普通票
 * @author Administrator
 *
 */
public class Ticket implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ScheduleItem scheduleItem;
	private Seat seat;
	private double price;
	
	public Ticket(ScheduleItem scheduleItem, Seat seat, double price) {
		super();
		this.scheduleItem = scheduleItem;
		this.seat = seat;
		this.price = price;
		
	}
	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ScheduleItem getScheduleItem() {
		return scheduleItem;
	}
	public void setScheduleItem(ScheduleItem scheduleItem) {
		this.scheduleItem = scheduleItem;
	}
	public Seat getSeat() {
		return seat;
	}
	public void setSeat(Seat seat) {
		this.seat = seat;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void show() {
		System.out.println("****************************");
		System.out.println("        ETC影院（普通票）                ");
		System.out.println("----------------------------");
		System.out.println("电影名：\t"+scheduleItem.getMovie().getMovieName());
		System.out.println("时间：\t"+scheduleItem.getTime());
		System.out.println("座位号：\t"+seat.getSeatNum());
		System.out.println("价格：\t￥"+price);
		System.out.println("****************************");
		
	}
	public void print() {
		File file=new File("src/com/cinema/file/"+scheduleItem.getMovie().getMovieName()+scheduleItem.getTime().replace(":","-"));
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		BufferedWriter bw=null;
		try {
			bw=new BufferedWriter(new FileWriter(file, true));
			bw.write("****************************");
			bw.newLine();
			bw.write("        ETC影院（普通票）                ");
			bw.newLine();
			bw.write("----------------------------");
			bw.newLine();
			bw.write("电影名：\t"+scheduleItem.getMovie().getMovieName());
			bw.newLine();
			bw.write("时间：\t"+scheduleItem.getTime());
			bw.newLine();
			bw.write("座位号：\t"+seat.getSeatNum());
			bw.newLine();
			bw.write("****************************");
			bw.newLine();
			bw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(bw!=null) {
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((scheduleItem == null) ? 0 : scheduleItem.hashCode());
		result = prime * result + ((seat == null) ? 0 : seat.hashCode());
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
		Ticket other = (Ticket) obj;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (scheduleItem == null) {
			if (other.scheduleItem != null)
				return false;
		} else if (!scheduleItem.equals(other.scheduleItem))
			return false;
		if (seat == null) {
			if (other.seat != null)
				return false;
		} else if (!seat.equals(other.seat))
			return false;
		return true;
	}
	
}
