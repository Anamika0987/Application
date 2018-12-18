package pl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


import bean.BookedDetail;
import bean.TicketBean;
import exception.TicketException;
import service.ITicketService;
import service.TicketServiceImpl;

public class TicketMain 
{
	
	static Scanner scanner = new Scanner(System.in);
	static ITicketService iTicketService = null;
	static TicketServiceImpl ticketServiceImpl = null;
	
	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException
	{
		//TicketBean ticketBean = null;
		//BookedDetail bookedDetail = null;
		
		//String trainNo = null;
		
		boolean pass = true;
		int opt;
		while(pass)
		{
			System.out.println(" enter 1 for user , enter 2 for admin :");
			opt = scanner.nextInt();
			switch(opt)
			{
			case 1:
				getUser();
				pass = false;
			case 2 :
				getAdmin();
				pass = false;
			default:
				System.out.println("enter valid choice :.........");
				break;
			}
		}
	}
	static public void getUser()
	{
		TicketBean ticketBean = null;
		BookedDetail bookedDetail = null;
		
		String trainNo = null;
		int option;
		int pnr;
		while(true)
		{
			
			System.out.println();
			System.out.println();
			System.out.println("	WELCOME TO ARCTC	");
			System.out.println("----------------------------");
			System.out.println("1. View Seat Availability");
			System.out.println("2. Retrieve Trains");
			System.out.println("3. Book Tickets");
			System.out.println("4. Exit");
			System.out.println("____________________________");
			System.out.println("\nEnter your Choice ");
			
			try
			{
				option = scanner.nextInt();
				switch (option)
				{
				case 1 :
					System.out.println(" Enter TrainNumber to see the availability of Seats ");
					trainNo = scanner.next();
					try
					{
						ticketBean = new TicketBean();
						iTicketService = new TicketServiceImpl();
						ticketServiceImpl = new TicketServiceImpl();
					
						if(ticketServiceImpl.validateTrainNumber(trainNo))
						{
							
							ticketBean= iTicketService.viewSeat(trainNo);
							if(ticketBean.getTrainNo()!=null)
								System.out.println(ticketBean);
							else
								System.out.println("Train Number doesn't Exists");
						}
						else
						{
							System.out.println("Train Number is not validated.");
						}
					}
					catch(Exception exc)
					{
						System.err.println("Error:"+exc.getMessage());
					}
					finally {
						trainNo = null;
						iTicketService = null;
						ticketBean = null;
						ticketServiceImpl=null;
					}
					
					break;
				case 2 :
					try
					{
						ticketBean = new TicketBean();
						iTicketService = new TicketServiceImpl();
						List<TicketBean> list=null;
						list=iTicketService.retrieveAll();
						
						
						if(!list.isEmpty()) {
							System.out.println(list);
						}
						else {
							throw new TicketException("There are NO Train");
						}
						 
					}
					catch(Exception e)
					{
						System.err.println("Error:"+e.getMessage());
					}
					finally {
						trainNo = null;
						iTicketService = null;
						ticketBean = null;
						ticketServiceImpl=null;
					}
					break;
				case 3 :
	
					System.out.println(" Enter TrainNumber in which u want to book ticket ");
					trainNo = scanner.next();
					
						 bookedDetail=new BookedDetail();
						iTicketService = new TicketServiceImpl();
						ticketServiceImpl = new TicketServiceImpl();
					
						if(ticketServiceImpl.validateTrainNumber(trainNo))
						{
							
								bookedDetail=populateBookingDetail();
								bookedDetail.setTrainNo(trainNo);
							
							try {
								
							pnr=iTicketService.bookTicket(bookedDetail);
							System.out.println("Booking confirmed....");
							System.out.println("Your PNR No is :"+ pnr);
							}catch (TicketException ticketException) {
								System.out.println("ERROR :" + ticketException.getMessage());
							}
							finally
							{
								trainNo = null;
								iTicketService = null;
								ticketServiceImpl=null;
								ticketBean = null;
								bookedDetail=null;
							}
							
						}
						else
						{
							System.out.println("Train Number is not validated.");
						}
				
	
					break;
				case 4:
					int tickcan;
					System.out.println("enter pnr:");
					pnr=scanner.nextInt();
					try {
						
						
						iTicketService=new TicketServiceImpl();
						tickcan=iTicketService.cancellation(pnr);
						System.out.println("passenger ,"+tickcan+"cancellation approved");
					
						
					} catch (Exception e) {
						System.out.println(e);
						break;
					}
				case 5 :
					System.exit(0);
					break;
				default :
					System.out.println(" give proper option :............");
					break;
				}
			}catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		
	}
	static public void getAdmin() throws ClassNotFoundException, IOException, SQLException
	{
		
		TicketBean ticketBean = null;
		BookedDetail bookedDetail = null;
		boolean t = true;
		String trainNo = null;
		while(t)
		{
		System.out.println();
		System.out.println();
		System.out.println("	WELCOME TO ARCTC	");
		System.out.println("----------------------------");
		System.out.println(" 1.add trains ");
		System.out.println(" 2. exit");
		int admin;
		
		System.out.println("enter option :");
		admin = scanner.nextInt();
		
		switch(admin)
		{
		
		case 1:
		while(ticketBean==null)
		{
			ticketBean=populateTicketBean();
		}
		try
		{
			iTicketService = new TicketServiceImpl();
			trainNo=iTicketService.addTain(ticketBean);
			System.out.println("Train details added successfully....");
			System.out.println("Train No is :"+ trainNo);
		}catch (TicketException ticketException) {
			System.out.println("ERROR :" + ticketException.getMessage());
		}
		finally
		{
			trainNo = null;
			iTicketService = null;
			ticketServiceImpl=null;
			ticketBean = null;
		}
		break;
		case 2:
			System.exit(0);
		default:
			System.out.println("not good");
			break;
		}
		}
		
	}

	private static BookedDetail populateBookingDetail() {
		BookedDetail bookedDetail = new BookedDetail();
		System.out.println("Enter Details :");
		
		System.out.println("\nEnter Passenger Name : ");
		bookedDetail.setPassangername(scanner.next());
		try {
		System.out.println("Enter Age : ");
		bookedDetail.setAge(scanner.nextInt());
		}catch (InputMismatchException inputMismatchException) {
			scanner.nextLine();
			System.err.println("Please enter a numeric value for Age, try again");
			}
		System.out.println("Enter PhoneNumber : ");
		bookedDetail.setPhonenumber(scanner.next());
		
		ticketServiceImpl = new TicketServiceImpl();
		
		try
		{
			ticketServiceImpl.validatePassenger(bookedDetail);
			return bookedDetail;
		}catch (TicketException e)
		{
			System.out.println("Invalid Data");
			System.err.println(e.getMessage() + " \n Try again..");
			System.exit(0);
		}
		
		return null;
	}

	private static TicketBean populateTicketBean() {
		
		TicketBean ticketBean = new TicketBean();
		System.out.println("Enter Train Details :");
		
		System.out.println("\nEnter Train Name : ");
		ticketBean.setTrainName(scanner.next());
		
		System.out.println("\nEnter Source : ");
		ticketBean.setSource(scanner.next());
		
		System.out.println("Enter Destination : ");
		ticketBean.setDestination(scanner.next());
		
		try
		{
		System.out.println("Enter Available Seats : ");
		ticketBean.setSeat(scanner.nextInt());
		}catch (InputMismatchException inputMismatchException) {
			scanner.nextLine();
			System.err.println("Please enter a numeric value for Availabe Seats, try again");
			}
		
		try
		{
		System.out.println("Enter Price : ");
		ticketBean.setPrice(scanner.nextDouble());
		}catch (InputMismatchException inputMismatchException) {
			scanner.nextLine();
			System.err.println("Please enter a numeric value for Price, try again");
			}
		
		ticketServiceImpl = new TicketServiceImpl();
		
		try
		{
			ticketServiceImpl.validateTrain(ticketBean);
			return ticketBean;
		}catch (TicketException e)
		{
			System.out.println("Invalid Data");
			System.err.println(e.getMessage() + " \n Try again..");
			System.exit(0);
		}
		
		return null;
	}
}
