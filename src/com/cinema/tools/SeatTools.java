package com.cinema.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.cinema.enitity.Seat;

public class SeatTools {
	/**
	 * 为一场电影初始化座位
	 * @param col
	 * @param row
	 * @return List<Seat>
	 */
	public static List<Seat> initSeat(int col,int row){
		List<Seat> seats=new ArrayList<Seat>();
		for (int i = 0; i <row; i++) {
			for (int j = 0; j < col; j++) {
				seats.add(new Seat((i+1)+"-"+(j+1)));
			}
		}
		return seats;
	}
	/**
	 * 显示尚未售出的座位
	 * @param seats
	 * @param file
	 */
	public static void printSeats(List<Seat> seats,File file) {
		List<Seat> soldedSeat=soldedSeat(file);
		for(int i=0;i<seats.size();i++) {
			System.out.print(" ");
		}
		System.out.println("屏幕");
		for(int i=0;i<seats.size();i++) {
			if(!soldedSeat.contains(seats.get(i))) {
				System.out.print(seats.get(i).getSeatNum()+"  ");
				}else {
					System.out.print("已售     ");
				}
			if((i+1)%7==0) {
				System.out.println();
				
			}
		}
	}
	/**
	 * 获得已售出的座位
	 * @param file
	 * @return List<Seat>	
	 */
	public static List<Seat> soldedSeat(File file){
		//System.out.println(file.getName());
		List<Seat> list=new ArrayList<Seat>();
		if(!file.exists()) {
			//System.out.println(file.getName());
			return list;
		}
		
		BufferedReader br=null;
				try {
					br=new BufferedReader(new FileReader(file));
					String str=br.readLine();
					while(str!=null) {
						if(str.matches("座位号：\\t[1-9]-[1-9]")) {
							String [] str1=str.split("\\t");
							list.add(new Seat(str1[1]));
						}
						str=br.readLine();
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					if(br!=null) {
						try {
							br.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
		return list;
		
	}
	
}
