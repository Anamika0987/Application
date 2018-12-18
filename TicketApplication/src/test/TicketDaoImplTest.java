package test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.sql.SQLException;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import bean.TicketBean;

import dao.TicketDaoImpl;
import exception.TicketException;


class TicketDaoImplTest {
	
	
	static TicketBean t;
	
	static TicketDaoImpl dao;
	
	@BeforeAll
	public static void initialize() {
		System.out.println("in before class");
		dao = new TicketDaoImpl();
		t=new TicketBean();
	}
	
	@Test
	 void testaddtrain() {
		//fail("Not yet implemented");
		t.setTrainName("chennaiexpress");
		t.setTrainNo("1002");
		t.setDestination("chennai");
		t.setSource("delhi");
		t.setPrice(800);
		assertEquals("chennaiexpress",t.getTrainName());
		assertEquals("1002",t.getTrainNo());
		assertEquals("chennai",t.getDestination());
		assertEquals("delhi",t.getSource());
		assertEquals(800,t.getPrice());
	}
	
	
 
	@Test
    	void retrieveAlltest() throws TicketException, ClassNotFoundException, IOException, SQLException
    	{
		assertNotNull(dao.retrieveAll());
		
    	}
    }

