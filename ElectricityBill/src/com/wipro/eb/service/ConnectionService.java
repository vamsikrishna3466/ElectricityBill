package com.wipro.eb.service;

import com.wipro.eb.entity.Commercial;
import com.wipro.eb.entity.Connection;
import com.wipro.eb.entity.Domestic;
import com.wipro.eb.exception.InvalidConnectionException;
import com.wipro.eb.exception.InvalidReadingException;

public class ConnectionService
{
	public boolean validate(int currentReading, int previousReading, String type) throws InvalidReadingException,InvalidConnectionException 
	{
		if(currentReading<previousReading||currentReading<0||previousReading<0)
		{
			throw new InvalidReadingException();
		}
		if(!(type.equalsIgnoreCase("Domestic")||type.equalsIgnoreCase("Commercial")))
		{
			throw new InvalidConnectionException();
		}
		return true;
	}
	public float calculateBillAmt(int currentReading, int previousReading, String type)
	{
		float bill=0.0f;
		try
		{
			boolean checkValidation=validate(currentReading,previousReading,type);
			if(checkValidation)
			{
				float electricityDuty;
				Connection connectionObject;
				boolean flag=false;
				float []connectionslabs=new float[3];
				if(type.equalsIgnoreCase("Domestic"))
				{
					connectionslabs[0]=2.3f;
					connectionslabs[1]=4.2f;
					connectionslabs[2]=5.5f;
					connectionObject=new Domestic(currentReading,previousReading,connectionslabs);
					
				}
				else
				{
					connectionslabs[0]=5.2f;
					connectionslabs[1]=6.8f;
					connectionslabs[2]=8.3f;
					connectionObject=new Commercial(currentReading,previousReading,connectionslabs);
					flag=true;
				}
				float billamount=connectionObject.computeBill();
				if(flag)
				{
				if(billamount<5000)
				{
					electricityDuty = 0.02f;
				}
				else if(billamount>=5000&&billamount<10000)
				{
					electricityDuty=0.06f;
				}
				else
				{
					electricityDuty=0.09f;
				}
				}
				else
				{
					electricityDuty=0.0f;
				}
				bill=billamount+billamount*electricityDuty;
			
			}
		}
		catch(InvalidReadingException invalidatereadingexceptionobject)
		{
			bill=(float) -1.0;
		}
		catch(InvalidConnectionException invalidconnectionexceptionobject)
		{
			bill=(float)-2.0;
		}
		
		return bill;
		
	}
	public String generateBill(int currentReading, int previousReading, String type)
	{
		float billvalue=calculateBillAmt(currentReading,previousReading,type);
		String answer;
		if(billvalue==-1.0)
		{
			answer="Incorrect Reading";
		}
		else if(billvalue==-2.0)
		{
			answer="Invalid ConnectionType";
		}
		else
		{
			answer="Amount to be paid:".concat(String.valueOf(billvalue)); 
			  
		}
		return answer;
	
	}
}
