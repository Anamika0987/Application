package TicktMain;
import java.util.Scanner;

import service.IPassengerService;

import service.PassengerServiceImpl;
import TicketBean.BookTicket;
import TicketBean.Passenger;
import TicketBean.Train;
public class MainTicket {
static Scanner sc = new Scanner(System.in);
	
	static PassengerServiceImpl passengerServiceImpl =null;
	static IPassengerService iPassengerService=null;
	

	public static void main(String[] args) {
		//System.out.println("enter 1 for train details,enter 2 for passenger details:");
		//int option=sc.nextInt();
		String trainNumber=null;
	
	Passenger pr=null;
		int option=0;
		boolean check=true;
		while(check) {
			System.out.println("WELCOME TO ARCTC");
			System.out.println("_______________________________\n");
			System.out.println("1.book ticket");
			System.out.println("2.cancel ticket");
			System.out.println("3.view your details");
			System.out.println("4.exit");
			System.out.println("________________________________");
			System.out.println("Select an option:");
			
			try {
				option = sc.nextInt();
				switch (option) {

				case 1:

					while (pr==null)
					{
						pr=populatePassenger();
					}
					try
					{
						
						BookTicket b=new BookTicket();//iPassengerService = new PassengerServiceImpl();
						//trainNumber=Book_ticket(bt);
						PassengerServiceImpl psi=new PassengerServiceImpl();
						b=psi.Book_ticket(pr);
						
						//System.out.println("trainnumber is: "+trainNumber);
						//pr.setTrainNumber(trainNumber);
					System.out.println(b);	
					}
					catch(Exception e){
						System.out.println("hi");
					}
					check=false;
					break;
					
			
	
			//catch (Exception e1) {
				//System.err.println("error :"+e1.getMessage());
		//	}
	
	
		/*case 2:
		System.out.println("enter trainnumber for viewing details:");
		trainNumber=sc.next();
		try {
		tre=new Train();
			ticketService=new TicketServiceImpl();
			ticketServiceImpl=new TicketServiceImpl();
			if(TicketServiceImpl.validateTrainNumber(trainNumber));
			{
			tre=ticketService;
			}
		}*/
	
				}//switch
			}//try
			catch (Exception e) {
				// TODO: handle exception
			}
			
		}//while
	}//main
	


	private static Passenger populatePassenger() {
		Passenger pr=new Passenger();
		System.out.println(" Enter passenger details ");
		System.out.println("-__________________");
		
		System.out.println(" Enter passenger name        : ");
		pr.setPassengerName(sc.next());
		
		
		System.out.println(" Enter train source  : ");
		pr.setSource(sc.next());
		
		System.out.println(" Enter train destination loc: ");
	pr.setDestination(sc.next());

		System.out.println("enter age  : ");
		pr.setAge(sc.nextInt());
		
		System.out.println("enter email");
		pr.setMailId(sc.next());
		
		
		passengerServiceImpl = new PassengerServiceImpl ();
		try {
		passengerServiceImpl.validatePassenger(pr);
		
		}
		
		catch(Exception e)
		{
			System.out.println(" invalid data : ");
			System.err.println(e.getMessage());
		}
		return null;                     
	}
}

//	
//	private static Train getTrain(String trainNumber)
//	{
//		return tre;
//	}
//
