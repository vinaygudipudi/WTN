package com.wipro.eb.service;

import com.wipro.eb.entity.Commercial;
import com.wipro.eb.entity.Connection;
import com.wipro.eb.entity.Domestic;
import com.wipro.eb.exception.InvalidConnectionException;
import com.wipro.eb.exception.InvalidReadingException;

public class ConnectionService {
	int currentReading;
	int previousReading;
	String type;
	public boolean validate(int currentReading,int previousReading,String type) throws InvalidReadingException,InvalidConnectionException
	{
		if(currentReading < previousReading || currentReading <0 || previousReading<0)
			throw new InvalidReadingException();
		if(!(type.equals("Domestic")|| type.equals("Commercial")))
			throw new InvalidConnectionException();
		if(currentReading>=previousReading && currentReading>0 && previousReading>0 && (type.equals("Domestic") || type.equals("Commercial")))
			return true;
		return false;
		
	}
	
	public float calculateBillAmt(int currentReading,int previousReading,String type)
	{
		float bill=0;
		try
		{
			if(validate(currentReading,previousReading,type))
			{
				Connection con=null;
				if(type.equals("Commercial"))
				{
					con=new Commercial(currentReading,previousReading,null);
					bill=con.computeBill();
				}
				
				else
				{
					con=new Domestic(currentReading,previousReading,null);
					bill=con.computeBill();
				}
				
			}
		}
			catch(InvalidConnectionException e)
			{
				return -2.0f;
			}
		catch(InvalidReadingException e)
		{
		return -1.0f;	
		}
		return bill;
	}
	public String generateBill(int currentReading,int previousReading,String type) {
	if(calculateBillAmt(currentReading,previousReading,type)== -1 )
	{
		return "Incorrect Reading";
	}
	if(calculateBillAmt(currentReading,previousReading,type)== -2 )
		
	{
		return "Invalid ConnectionType";
		
		
	
	
	}
	else
	{
		String s1="Amount to be Paid is:"+calculateBillAmt(currentReading,previousReading,type);
		return s1;
	}
	}
	
				
				

		
		
	

}

