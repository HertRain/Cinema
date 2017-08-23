package com.cinema.ticketfactory;

import com.cinema.enitity.Ticket;

public class TicketFactory implements CreatFactory{

	@Override
	public Ticket creatTicket() {
		// TODO Auto-generated method stub
		return new Ticket();
	}
	

}
