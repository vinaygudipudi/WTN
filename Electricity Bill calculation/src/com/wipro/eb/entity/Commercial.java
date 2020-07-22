package com.wipro.eb.entity;

public class Commercial extends Connection {

	public Commercial(int currentReading, int previousReading, float[] slabs) {
		super( currentReading, previousReading,slabs);
		// TODO Auto-generated constructor stub
	}
	
	public float computeBill()
	{
		int br;
		br = currentReading - previousReading;
		float bill=0;
		
		if(br >=0 && br<=50)
		{
			bill=(float)(br*5.2);
		}
		else if(br>50 && br<=100)
		{
			bill = (float) ((50 * 5.2) + ((br-50)*6.8));
		}
		else
		{
			bill=(float)(50*5.2+50*6.8+(br-100)*8.3);
		}
		
		if(bill<5000)
			return (float)(bill+bill*0.02);
		else if(bill>=5000 && bill<10000)
			return (float)(bill+bill*0.06);
		else
			return (float)(bill+bill*0.09);
		
		
	}
	

}
