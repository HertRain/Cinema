package com.cinema.enitity;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FreeTicket extends Ticket{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userName;
	public FreeTicket() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FreeTicket(ScheduleItem scheduleItem, Seat seat) {
		super(scheduleItem, seat,0);
		// TODO Auto-generated constructor stub
	}
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void show() {
		System.out.println("****************************");
		System.out.println("        ETCӰԺ����Ʊ��                ");
		System.out.println("----------------------------");
		System.out.println("��Ӱ����\t"+super.getScheduleItem().getMovie().getMovieName());
		System.out.println("ʱ�䣺\t"+super.getScheduleItem().getTime());
		System.out.println("��λ�ţ�\t"+super.getSeat().getSeatNum());
		System.out.println("��Ʊ�ˣ�\t"+userName);
		System.out.println("****************************");
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
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
		FreeTicket other = (FreeTicket) obj;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
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
			bw.write("        ETCӰԺ����Ʊ��                ");
			bw.newLine();
			bw.write("----------------------------");
			bw.newLine();
			bw.write("��Ӱ����\t"+super.getScheduleItem().getMovie().getMovieName());
			bw.newLine();
			bw.write("ʱ�䣺\t"+super.getScheduleItem().getTime());
			bw.newLine();
			bw.write("��λ�ţ�\t"+super.getSeat().getSeatNum());
			bw.newLine();
			bw.write("��Ʊ�ˣ�\t"+userName);
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
