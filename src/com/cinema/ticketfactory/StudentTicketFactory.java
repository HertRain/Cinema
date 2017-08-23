package com.cinema.ticketfactory;

import com.cinema.enitity.StudentTicket;
import com.cinema.enitity.Ticket;

public class StudentTicketFactory implements CreatFactory{

	@Override
	public Ticket creatTicket() {
		// TODO Auto-generated method stub
		return new StudentTicket();
	}

}
