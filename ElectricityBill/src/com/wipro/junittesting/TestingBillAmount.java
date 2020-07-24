package com.wipro.junittesting;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import com.wipro.eb.service.ConnectionService;
@RunWith(Parameterized.class)
public class TestingBillAmount 
{
		private int currentReading;
		private int previousReading;
		private String type;
		private float billamount;
		private ConnectionService connectionserviceobject;
		public TestingBillAmount(int currentReading, int previousReading, String type,float billamount)
		{
			this.currentReading=currentReading;
			this.previousReading=previousReading;
			this.type=type;
			this.billamount=billamount;
		}
		@Parameterized.Parameters
		public static Collection generateData()
		{
			return Arrays.asList(new Object[][] {{10,4,"Domestic",13.8f},{55,4,"Domestic",119.2f},{120,56,"Domestic",173.79f},
{10,5,"Commercial",26.52f},{55,11,"Commercial",233.376f},{110,4,"Commercial",662.796f}});
		}
		@Before
		public void intialization()
		{
			connectionserviceobject=new ConnectionService();
		}
		@Test
		public void testing()
		{
			assertEquals(billamount,connectionserviceobject.calculateBillAmt(currentReading, previousReading, type),0.1);
			
		}
}
