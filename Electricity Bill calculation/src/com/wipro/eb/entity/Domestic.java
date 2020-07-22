package com.wipro.eb.entity;

public class Domestic extends Connection {
	int currentReading;
	int previousReading;
	float slabs[];
	
	public Domestic(int currentReading,int previousReading,  float[] slabs) {
		super( currentReading, previousReading,slabs);
		
	}
	
	public float computeBill() {
		//balance reading
		int br;
		br = currentReading - previousReading;
		float bill=0;
		
		if(br >=0 && br<=50)
		{
			bill=(float)(br*2.3);
		}
		else if(br>50 && br<=100)
		{
			bill = (float) ((50 * 2.3) + ((br-50)*4.2));
		}
		else
		{
			bill=(float)(50*2.3+50*4.2+(br-100)*5.5);
		}
		
		return bill;
		
		
	}
	

	
	
	}
	
	
	

