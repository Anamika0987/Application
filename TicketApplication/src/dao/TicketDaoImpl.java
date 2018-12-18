package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;

import bean.BookedDetail;
import bean.TicketBean;
import exception.TicketException;
import util.Dbconnection;

public class TicketDaoImpl implements ITicketDao {

	
	@Override
	public String addTain(TicketBean ticketBean) throws TicketException, ClassNotFoundException, IOException, SQLException {
		Connection connection = Dbconnection.getConnection();
		Statement statement = connection.createStatement();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		String trainNo = null;
		int queryResult = 0;
		
		try
		{
			
			preparedStatement = connection.prepareStatement(QueryMapper.INSERT_QUERY);
			preparedStatement.setString(1, ticketBean.getTrainName());
			preparedStatement.setString(2, ticketBean.getSource());
			preparedStatement.setString(3, ticketBean.getDestination());
			preparedStatement.setInt(4, ticketBean.getSeat());
			preparedStatement.setDouble(5, ticketBean.getPrice());
			
			preparedStatement.executeUpdate();
			
			resultSet = statement.executeQuery(QueryMapper.DISPLAY_QUERY);
			
			while(resultSet.next())
			{
				trainNo = resultSet.getString(1);
								
			}
			return trainNo;
			
		}catch (Exception e)
		{
			System.out.println(e);
		}
		
		return null;

		
	}

	

	

	@Override
	public List<TicketBean> retrieveAll() throws TicketException, ClassNotFoundException, IOException, SQLException {
		Connection con= Dbconnection.getConnection();
		Statement st=con.createStatement();
		
		List<TicketBean> list=null;
		ResultSet rs=null;
		try {
		rs=st.executeQuery(QueryMapper.RETRIVE_ALL_QUERY);
		list=new ArrayList<>();
		while(rs.next())
		{
			TicketBean ticketBean= new TicketBean();
			ticketBean.setTrainNo(rs.getString(1));
			ticketBean.setTrainName(rs.getString(2));
			ticketBean.setSource(rs.getString(3));
			ticketBean.setDestination(rs.getString(4));
			ticketBean.setSeat(rs.getInt(5));
			ticketBean.setPrice(rs.getDouble(6));
			
			list.add(ticketBean);
			
		}
		return list;
		}
		catch (SQLException e) {
			throw new TicketException("Problem in Viewing Trains from database!!");
		}
		finally
		{
				try 
				{
					rs.close();
					con.close();
				}
				catch (SQLException sqlException) 
				{
					sqlException.printStackTrace();
					
					throw new TicketException("Error in closing db connection");

				}
		}
	}



	@Override
	public TicketBean viewSeat(String trainNo) throws TicketException, ClassNotFoundException, IOException, SQLException {
		Connection connection = Dbconnection.getConnection();
		
		Statement st = connection.createStatement();
		TicketBean ticketBean = new TicketBean();
		ResultSet rs = null;
		try {
		rs = st.executeQuery(QueryMapper.VIEW_DONAR_DETAILS_QUERY);
		
		while(rs.next())
		{
		ticketBean.setTrainNo(rs.getString(1));
		ticketBean.setTrainName(rs.getString(2));
		ticketBean.setSource(rs.getString(3));
		ticketBean.setDestination(rs.getString(4));
		ticketBean.setSeat(rs.getInt(5));
		ticketBean.setPrice(rs.getDouble(6));
		}
		
		return ticketBean;
		}
		catch (SQLException e) {
			throw new TicketException("Problem in Viewing Train from database!!");
		}
		finally
		{
				try 
				{
					rs.close();
					connection.close();
				}
				catch (SQLException sqlException) 
				{
					sqlException.printStackTrace();
					
					throw new TicketException("Error in closing db connection");

				}
		}
		
	}





	@Override
	public int bookTicket(BookedDetail bookedDetail) throws TicketException, ClassNotFoundException, IOException, SQLException{
		Connection connection = Dbconnection.getConnection();
		Statement statement = connection.createStatement();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		int pnr=0;
		
		boolean dummy=false;
		String trainno=bookedDetail.getTrainNo();
		try
		{
			
			resultSet=statement.executeQuery(QueryMapper.BOOk_QUERY_SEQUENCE);
			while(resultSet.next()) {
				if(trainno.equals(resultSet.getString(1))) {
					dummy=true;
				}
			}
			if(dummy==true) {
			preparedStatement = connection.prepareStatement(QueryMapper.DETAILS_QUERY);
			preparedStatement.setString(1,bookedDetail.getTrainNo());
			preparedStatement.setString(2,bookedDetail.getPassangername());
			preparedStatement.setInt(3,bookedDetail.getAge());
			preparedStatement.setString(4,bookedDetail.getPhonenumber());
			
			
			preparedStatement.executeUpdate();
			
			resultSet = statement.executeQuery(trainno);
			
			while(resultSet.next())
			{
				pnr = resultSet.getInt(6);
								
			}
			return pnr;
			}
			else{
				System.out.println("train not found");
				throw new TicketException("Train Doesn't exist");
			}
		}catch (SQLException e) {
			throw new TicketException("Problem in Booking ticket!!");
		}
		finally
		{
				try 
				{
					resultSet.close();
					preparedStatement.close();
					connection.close();
				}
				catch (SQLException sqlException) 
				{
					sqlException.printStackTrace();
					
					throw new TicketException("Error in closing db connection");

				}
		}
		
		
	}





	@Override
	public int cancellation(int pnr) {
		// TODO Auto-generated method stub
		return 0;
	}

}
