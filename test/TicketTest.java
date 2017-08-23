import static org.junit.Assert.*;

import org.junit.Test;

import com.cinema.datadao.MovieDao;
import com.cinema.datadao.impl.MovieBiz;
import com.cinema.enitity.ScheduleItem;
import com.cinema.enitity.Seat;
import com.cinema.enitity.Ticket;
import com.cinema.tools.MovieTools;

public class TicketTest {
	
	@Test
	public void testPrint() {
		Ticket t=new Ticket();
		Seat seat=new Seat("1-1");
		ScheduleItem item=new MovieBiz().getAllMovie().getItems().get(0);
		t.setPrice(item.getMovie().getPrice());
		t.setScheduleItem(item);
		t.setSeat(seat);
		t.print();
	}

}
