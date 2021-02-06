//package com.stir.cscu9t4practical1; 

public class SwimEntry extends Entry
{
	String location;
	
	public SwimEntry (String n, int d, int m, int y, int h, int min, int s, float dist
			,String loc)
	{
		super(n,d,m,y,h,min,s,dist);
		this.location = loc;
	}
	
	public String getLocation()
	{
		return location;
	}
	
	public String getEntry()
	{
		String result = getName()+" swam " + getDistance() + " km in "
	             +getHour()+":"+getMin()+":"+ getSec() + " on "
	             +getDay()+"/"+getMonth()+"/"+getYear()+"\n" 
	             +getLocation()+"\n";
	   return result;
	}
}

