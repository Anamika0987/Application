package service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import bean.BookedDetail;
import bean.TicketBean;
import dao.ITicketDao;
import dao.TicketDaoImpl;
import exception.TicketException;

public class TicketServiceImpl implements ITicketService
{

	ITicketDao iticketdao=null;
	
	@Override
	public String addTain(TicketBean ticketBean) throws TicketException, ClassNotFoundException, IOException, SQLException {
		String trainNoseq;
		iticketdao=new TicketDaoImpl();
		trainNoseq = iticketdao.addTain(ticketBean);
		return trainNoseq;
	}

	

	@Override
	public List<TicketBean> retrieveAll() throws TicketException, ClassNotFoundException, IOException, SQLException {
		List<TicketBean> list = new ArrayList<>();
		iticketdao = new TicketDaoImpl();
		list = iticketdao.retrieveAll();
		return list;
	}

	
	private boolean isValidPrice(double price) {
	
		return price>0;
	}

	private boolean isValidSeat(int seat) {
	
		return seat>0;
	}

	private boolean isValidDestinationName(String destination) {
		Pattern bpattern = Pattern.compile("^[A-Za-z]{3,}$");
		Matcher bmatcher = bpattern.matcher(destination);
		return bmatcher.matches();
	}

	private boolean isValidSourceName(String source) {
		Pattern bpattern = Pattern.compile("^[A-Za-z]{3,}$");
		Matcher bmatcher = bpattern.matcher(source);
		return bmatcher.matches();
	}

	private boolean isValidTrainName(String trainName)
	{
		
		Pattern bpattern = Pattern.compile("^[A-Za-z]{5,}$");
		Matcher bmatcher = bpattern.matcher(trainName);
		return bmatcher.matches();
	}

	public void validateTrain(TicketBean ticketBean) throws TicketException {

		List <String> validationError  = new ArrayList<String>();
		if(!(isValidTrainName(ticketBean.getTrainName())))
		{
			
			validationError.add("\n Train name should be in alphabet and minimum 5 character. ");
		}
		
		if(!(isValidSourceName(ticketBean.getSource())))
		{
			
			validationError.add("\n Source name should be in alphabet and minimum 3 characters. ");
		}
		
		if(!(isValidDestinationName(ticketBean.getDestination())))
		{
			validationError.add("\n Destination name should be in alphabet and minimum 3 characters. ");
		}
		
		if(!(isValidSeat(ticketBean.getSeat())))
		{
			validationError.add("\n Quantity should be positive. ");
		}
		
		if(!(isValidPrice(ticketBean.getPrice())))
		{
			validationError.add("\n Price should be positive. ");
		}
		
		if(!(validationError.isEmpty()))
		{
			throw new TicketException(validationError+" ");
		}
		
		
	}

	public boolean validateTrainNumber(String trainNo) {
		Pattern bpattern = Pattern.compile("^[1-9][0-9]{2,3}$");
		Matcher bmatcher = bpattern.matcher(trainNo);
		return bmatcher.matches();
	}



	@Override
	public TicketBean viewSeat(String trainNo) throws TicketException, ClassNotFoundException, IOException, SQLException {
		iticketdao = new TicketDaoImpl();
		TicketBean ticketBean;
		
		ticketBean = iticketdao.viewSeat(trainNo);	
		
		return ticketBean;
		
	}



	public void validatePassenger(BookedDetail bookedDetail) throws TicketException {
		List <String> validationError  = new ArrayList<String>();
		if(!(isValidName(bookedDetail.getPassangername())))
		{
			
			validationError.add("\n Passenger name should be in alphabet and minimum 5 character. ");
		}
		
		if(!(isValidAge(bookedDetail.getAge())))
		{
			
			validationError.add("\n Age should be positive .");
		}
		
		
		if(!(isValidNumber(bookedDetail.getPhonenumber())))
		{
			validationError.add("\n Phone number should be 10 digit and starting from 6,7,8 or 9");
		}
		
		if(!(validationError.isEmpty()))
		{
			throw new TicketException(validationError+" ");
		}
		
	}



	private boolean isValidNumber(String phonenumber) {
		Pattern bpattern = Pattern.compile("^[6-9][0-9]{9}$");
		Matcher bmatcher = bpattern.matcher(phonenumber);
		return bmatcher.matches();
	}



	private boolean isValidAge(int age) {
		
		return age>0;
	}



	private boolean isValidName(String passangername) {
		Pattern bpattern = Pattern.compile("^[A-Za-z]{5,}$");
		Matcher bmatcher = bpattern.matcher(passangername);
		return bmatcher.matches();
	}





	@Override
	public int bookTicket(BookedDetail bookedDetail) throws ClassNotFoundException, TicketException, IOException, SQLException {
		iticketdao=new TicketDaoImpl();
		int pnr;
		pnr=iticketdao.bookTicket(bookedDetail);
		return pnr;
	}





	@Override
	public int cancellation(int pnr) {
		iticketdao=new TicketDaoImpl();
		int pnr_seq;
		pnr_seq=iticketdao.cancellation(pnr);
		return pnr_seq;
	}

}
