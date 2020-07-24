package com.wipro.eb.exception;

@SuppressWarnings("serial")
public class InvalidConnectionException extends Exception{
	@Override
	public String toString()
	{
		return "Invalid ConnectionType";
	}

}
