package com.wipro.junittesting;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.wipro.eb.exception.InvalidConnectionException;
import com.wipro.eb.exception.InvalidReadingException;
import com.wipro.eb.service.ConnectionService;
@RunWith(Parameterized.class)
public class GenerateBillTesting {

	private int currentReading;
	private int previousReading;
	private String type;
	private String bill;
	private ConnectionService connectionserviceobject;
	public GenerateBillTesting(int currentReading, int previousReading, String type,String bill)
	{
		this.currentReading=currentReading;
		this.previousReading=previousReading;
		this.type=type;
		this.bill=bill;
	}
	@Parameterized.Parameters
	public static Collection generateData()
	{
		return Arrays.asList(new Object[][] {
			{2,4,"Domestic","Incorrect Reading"},{55,4,"Dik","Invalid ConnectionType"},{10,4,"Domestic","Amount to be paid:13.8"}});
	}
	@Before
	public void intialization()
	{
		connectionserviceobject=new ConnectionService();
	}
	@Test
	public void testing() throws InvalidReadingException, InvalidConnectionException
	{
		assertEquals(bill,connectionserviceobject.generateBill(currentReading, previousReading, type));
		
	}

}
