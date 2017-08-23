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
			System.out.println("欢迎使用ETC在线售票系统");
			schedule.printMovie();
			Scanner input=new Scanner(System.in);
			int msg=0;
			System.out.println("请选择电影(输入电影序号)：");
			msg=input.nextInt();
			
			while(msg<1||msg>schedule.getItems().size()) {
				System.out.println("没有这部电影序号！");
				System.out.println("请选择电影(输入电影序号)：");
				msg=input.nextInt();
			}
			Movie movie=schedule.getItems().get(msg-1).getMovie();
			ScheduleItem item=schedule.getItems().get(msg-1);
			File file=new File("src/com/cinema/file/"+movie.getMovieName()+schedule.getItems().get(msg-1).getTime().replace(':','-'));
			SeatTools.printSeats(seats,file);
			System.out.println("请输入座位号(例如“1-1”)：");
			String seat=input.next();
			
			while(SeatTools.soldedSeat(file).contains(new Seat(seat))){
				System.out.println("该座位已售出！");
				System.out.println("请输入座位号(例如“1-1”)：");
				seat=input.next();
			}
			System.out.println("1.普通票   2.学生票");
			System.out.println("请选择：");
			
			msg=input.nextInt();
			Ticket t;
			while(true){
				 t=factory(msg);
				 if(t!=null){
					 break;
				 }
				    System.out.println("请选择：");
					msg=input.nextInt();
			}
			t.setPrice(movie.getPrice());
			t.setScheduleItem(item);
			t.setSeat(new Seat(seat));
			t.show();
			System.out.println("确定（y）/取消（n）");
			seat=input.next();
			while(!"y".equals(seat)&&!"n".equals(seat)) {
				System.out.println("输入错误.....");
				System.out.println("确定购票（y）/取消购票（n）");
				seat=input.next();
			}
			if("y".equals(seat)){
			System.out.println("购买成功");
			t.print();
			}else {
				System.out.println("取消购票");
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
			System.out.println("没有这个选项！");
		}
		return null;
		
	}
	
}
