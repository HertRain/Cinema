package com.cinema.activity;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.cinema.datadao.MovieDao;
import com.cinema.datadao.impl.MovieBiz;
import com.cinema.enitity.Movie;
import com.cinema.enitity.MovieType;
import com.cinema.enitity.Schedule;
import com.cinema.enitity.ScheduleItem;
import com.cinema.enitity.Seat;
import com.cinema.enitity.Ticket;
import com.cinema.ticketfactory.FreeTicketFactory;
import com.cinema.ticketfactory.StudentTicketFactory;
import com.cinema.ticketfactory.TicketFactory;
import com.cinema.tools.SeatTools;

public class TicketSele {
	

	public static void main(String[] args) {
		MovieDao movieDao=new MovieBiz();
		Schedule schedule=movieDao.getAllMovie();
		
		List<Seat> seats=SeatTools.initSeat(7,5);
		//
		while(true) {
			System.out.println("��ӭʹ��ETC������Ʊϵͳ");
			schedule.printMovie();
			Scanner input=new Scanner(System.in);
			int msg=0;
			System.out.println("��ѡ���Ӱ(�����Ӱ���)��");
			msg=input.nextInt();
			
			while(msg<1||msg>schedule.getItems().size()) {
				System.out.println("û���ⲿ��Ӱ��ţ�");
				System.out.println("��ѡ���Ӱ(�����Ӱ���)��");
				msg=input.nextInt();
			}
			Movie movie=schedule.getItems().get(msg-1).getMovie();
			ScheduleItem item=schedule.getItems().get(msg-1);
			File file=new File("src/com/cinema/file/"+movie.getMovieName()+schedule.getItems().get(msg-1).getTime().replace(':','-'));
			SeatTools.printSeats(seats,file);
			System.out.println("��������λ��(���硰1-1��)��");
			String seat=input.next();
			
			while(SeatTools.soldedSeat(file).contains(new Seat(seat))){
				System.out.println("����λ���۳���");
				System.out.println("��������λ��(���硰1-1��)��");
				seat=input.next();
			}
			System.out.println("1.��ͨƱ   2.ѧ��Ʊ");
			System.out.println("��ѡ��");
			
			msg=input.nextInt();
			Ticket t;
			while(true){
				 t=factory(msg);
				 if(t!=null){
					 break;
				 }
				    System.out.println("��ѡ��");
					msg=input.nextInt();
			}
			t.setPrice(movie.getPrice());
			t.setScheduleItem(item);
			t.setSeat(new Seat(seat));
			t.show();
			System.out.println("ȷ����y��/ȡ����n��");
			seat=input.next();
			while(!"y".equals(seat)&&!"n".equals(seat)) {
				System.out.println("�������.....");
				System.out.println("ȷ����Ʊ��y��/ȡ����Ʊ��n��");
				seat=input.next();
			}
			if("y".equals(seat)){
			System.out.println("����ɹ�");
			t.print();
			}else {
				System.out.println("ȡ����Ʊ");
			}
		}	
	}
	public static Ticket factory(int msg) {
		switch(msg) {
		case 1:
			return new TicketFactory().creatTicket();
		case 2:
			return new StudentTicketFactory().creatTicket();
		/*case 3:
			return new FreeTicketFactory().creatTicket();*/
		default:
			System.out.println("û�����ѡ�");
		}
		return null;
		
	}
	
}
