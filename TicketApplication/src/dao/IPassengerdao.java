package dao;

import java.io.IOException;
import java.sql.SQLException;

import Exception.TrainException;
import TicketBean.BookTicket;
import TicketBean.Passenger;

public interface IPassengerdao {
	public BookTicket Book_ticket(Passenger pr) throws SQLException, ClassNotFoundException, IOException;
	public String cancel_ticket(Passenger pr);
	public String add_Train(Passenger pr);
	//public Train viewTrainDetails() throws TrainException;
	
	public void validatePassenger(Passenger pr) throws TrainException;
	String Book_ticket1(Passenger pr);
}

