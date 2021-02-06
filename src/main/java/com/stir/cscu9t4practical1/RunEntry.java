//package com.stir.cscu9t4practical1; 

public class RunEntry extends Entry
{
	int laps;
	
	public RunEntry (String n, int d, int m, int y, int h, int min, int s, float dist
			,int l)
	{
		super(n,d,m,y,h,min,s,dist);
		this.laps = l;

	}
	//constructor
	
	public int getLaps()
	{
		return laps;
	}
	//getLaps
	
	public String getEntry()
	{
		String result = getName()+" ran " + getDistance() + "km *" + getLaps() + " in"
	             +getHour()+":"+getMin()+":"+ getSec() + " on "
	             +getDay()+"/"+getMonth()+"/"+getYear()+"\n"; 

	   return result;
	}
	//getEntry
}

