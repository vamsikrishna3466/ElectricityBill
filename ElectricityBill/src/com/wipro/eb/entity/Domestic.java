package com.wipro.eb.entity;

public class Domestic extends Connection 
{
	public Domestic(int currentReading, int previousReading,float slabs[]) 
	{
		super(currentReading,previousReading,slabs);
	}
	public float computeBill()
	{
		float billAmount;
		int units=currentReading-previousReading;
		if(units<=50)
		{
			billAmount=slabs[0]*units;
		}
		else if(units<=100)
		{
			billAmount=(slabs[0]*50)+(slabs[1]*(units-50));
		}
		else
		{
			billAmount=(slabs[0]*50)+(slabs[1]*50)+(slabs[2]*(units-100));
		}
		
		return billAmount;
			}
}
