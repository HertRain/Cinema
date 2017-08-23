package com.cinema.ticketfactory;

import com.cinema.enitity.FreeTicket;
import com.cinema.enitity.Ticket;

public class FreeTicketFactory implements CreatFactory{

	@Override
	public Ticket creatTicket() {
		// TODO Auto-generated method stub
		return new FreeTicket();
	}

}
