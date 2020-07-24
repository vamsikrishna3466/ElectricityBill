package com.wipro.junittesting;
import static org.junit.Assert.assertEquals;
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
public class ValidationTesting 
{
		private int currentReading;
		private int previousReading;
		private String type;
		private boolean checkValidation;
		private ConnectionService connectionserviceobject;
		public ValidationTesting(int currentReading, int previousReading, String type,boolean checkValidation)
		{
			this.currentReading=currentReading;
			this.previousReading=previousReading;
			this.type=type;
			this.checkValidation=checkValidation;
		}
		@Parameterized.Parameters
		public static Collection generateData()
		{
			return Arrays.asList(new Object[][] {
				{2,4,"Domestic",false},{55,4,"Dom",false},{120,56,"Domestic",true}});
		}
		@Before
		public void intialization()
		{
			connectionserviceobject=new ConnectionService();
		}
		@Test
		public void testing() throws InvalidReadingException, InvalidConnectionException
		{
			assertEquals(checkValidation,connectionserviceobject.validate(currentReading, previousReading, type));
			
		}
}
