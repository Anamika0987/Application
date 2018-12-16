package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DBConnection.Dbconn;
import Exception.TrainException;
import TicketBean.BookTicket;
import TicketBean.Passenger;

public class PassengerDaoImpl implements IPassengerdao {

	@Override
	public BookTicket Book_ticket(Passenger pr) throws SQLException, ClassNotFoundException, IOException {
		Connection connection=Dbconn.getConnection();
		//Statement st=connection.createStatement();
		PreparedStatement preparedstatement=null;
	ResultSet resultSet=null;
		//Passenger pr=new Passenger();
	BookTicket bt=null;
	Statement st1=null;	
	Statement st=null;
	 st=connection.createStatement();
	 st1=connection.createStatement();
	// ResultSet rs=st.executeQuery("select max(pnr) from Passenger");
	
		preparedstatement = connection.prepareStatement("insert into passenger values(?,?,?,?,?,pnr_seq.nextval)");
	
	preparedstatement.setString(1,pr.getPassengerName());
	preparedstatement.setString(2,pr.getSource());
	preparedstatement.setString(3,pr.getMailId());
	preparedstatement.setString(4,pr.getPhonenumber());
	preparedstatement.setString(5,pr.getDestination());
		
	preparedstatement.executeUpdate();
	
ResultSet rs=st.executeQuery("select max(pnr) from Passenger");
//query for selecting max(pnr) from passenger
int pnr=0;
if(rs.next()) {
	pnr=rs.getInt(1);
}
	preparedstatement.executeUpdate();
	resultSet=st1.executeQuery("select * from train where source =? and destinatio=?");

	
		if(resultSet.next())
		{
			//System.out.println(" PassengerName: "+resultSet.getString(1)+"Source : "+resultSet.getString(2)+"destination: "+resultSet.getString(3));
			 bt=new BookTicket();
			bt.setTrainNumber(resultSet.getString(1));
			bt.setTrainName(resultSet.getString(2));
			bt.setPrice(resultSet.getInt(3));
			bt.setPnr(resultSet.getInt(4));
			//set the max(pnr) to bt object
			
		}
		return bt;		
	}
	

		
	
//	@Override

	

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
		
	}





	@Override
	public String Book_ticket1(Passenger pr) {
		// TODO Auto-generated method stub
		return null;
	}

}
