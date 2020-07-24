package com.wipro.eb.main;

import java.io.*;

import com.wipro.eb.service.ConnectionService;

public class EBMain {

	public static void main(String[] args) 
	{
		try(BufferedReader bufferedreaderobject=new BufferedReader(new InputStreamReader(System.in)))
		{
		int currentReading;
		int previousReading;
		String type;
		System.out.println("Enter previous Reading");
		previousReading=Integer.parseInt(bufferedreaderobject.readLine());
		System.out.println("Enter current Reading");
		currentReading=Integer.parseInt(bufferedreaderobject.readLine());
		System.out.println("Enter Connection Type");
		type=bufferedreaderobject.readLine();
		ConnectionService connectionserviceobject=new ConnectionService();
		System.out.println(connectionserviceobject.generateBill(currentReading,previousReading,type));
		}
		catch(Exception exceptionobject)
		{
			exceptionobject.printStackTrace();
		}
	}

}
