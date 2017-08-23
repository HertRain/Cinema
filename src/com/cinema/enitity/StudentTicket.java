package com.cinema.enitity;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class StudentTicket extends Ticket{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int discount=6;
	public StudentTicket() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StudentTicket(ScheduleItem scheduleItem, Seat seat, double price) {
		super(scheduleItem, seat, price);
		// TODO Auto-generated constructor stub
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public void compute() {
		super.setPrice(super.getPrice()*discount/10);
	}
	@Override
	public void setPrice(double price) {
		super.setPrice(price*discount/10);
	}
	public void show() {
		System.out.println("****************************");
		System.out.println("        ETC影院（学生票）                ");
		System.out.println("----------------------------");
		System.out.println("电影名：\t"+super.getScheduleItem().getMovie().getMovieName());
		System.out.println("时间：\t"+super.getScheduleItem().getTime());
		System.out.println("座位号：\t"+super.getSeat().getSeatNum());
		System.out.println("价格：\t￥"+super.getPrice());
		System.out.println("****************************");
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + discount;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentTicket other = (StudentTicket) obj;
		if (discount != other.discount)
			return false;
		return true;
	}
	public void print() {
		File file=new File("src/com/cinema/file/"+super.getScheduleItem().getMovie().getMovieName()+super.getScheduleItem().getTime().replace(":","-"));
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
			bw.write("        ETC影院（学生票）                ");
			bw.newLine();
			bw.write("----------------------------");
			bw.newLine();
			bw.write("电影名：\t"+super.getScheduleItem().getMovie().getMovieName());
			bw.newLine();
			bw.write("时间：\t"+super.getScheduleItem().getTime());
			bw.newLine();
			bw.write("座位号：\t"+super.getSeat().getSeatNum());
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
	
}
