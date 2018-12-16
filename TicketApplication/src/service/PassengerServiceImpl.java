package service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Exception.TrainException;
import TicketBean.BookTicket;
import TicketBean.Passenger;

public class PassengerServiceImpl implements IPassengerService {

	@Override
	public BookTicket Book_ticket(Passenger pr) {
		PassengerServiceImpl psi=new PassengerServiceImpl();
		return null;
	}

	@Override
	public String cancel_ticket(Passenger pr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String add_Train(Passenger pr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void validatePassenger(Passenger pr) throws TrainException {
		// TODO Auto-generated method stub
List<String> validationErrors=new ArrayList<String>();
		
		if(!(isValidPassengerName(pr.getPassengerName()))) {
			validationErrors.add("Train name should be in alphabets and 10 characters long");
		}
		if(!(isvalidSource(pr.getSource()))){
			validationErrors.add("Source should be greater than 5 characters ");
		}
		if(!(isvalidDestination(pr.getDestination()))) {
			validationErrors.add("Destination should be greater than 5 characters ");
		}
		if(!(isvalidSource(pr.getMailId()))){
			validationErrors.add("Price should be positive");
		}
		if(!validationErrors.isEmpty())
			throw new TrainException(validationErrors+" ");
			
		
	}

	private boolean isvalidDestination(String destination) {
		Pattern destPattern =Pattern .compile("^[A-Za-z]{5,}$");
		Matcher destMatcher=destPattern.matcher(destination);
		return destMatcher.matches();
		
	}

	private boolean isvalidSource(String source) {
		// TODO Auto-generated method stub
		Pattern sourcePattern =Pattern .compile("^[A-Za-z]{5,}$");
		Matcher sourceMatcher=sourcePattern.matcher(source);
		return sourceMatcher.matches();
	}

	private boolean isValidPassengerName(String passengerName) {
		Pattern passengerNamePattern =Pattern .compile("^[A-Za-z]{5,}$");
		Matcher passengerNameMatcher=passengerNamePattern.matcher(passengerName);
		return passengerNameMatcher.matches();
	}
	}


