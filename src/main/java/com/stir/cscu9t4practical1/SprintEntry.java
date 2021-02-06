//package com.stir.cscu9t4practical1; 

public class SprintEntry extends Entry
{
	int recovery;
	int laps;
	
	public SprintEntry(String n, int d, int m, int y, int h, int min, int s, float dist
			, int r, int l)
	{
		super(n,d,m,y,h,min,s,dist);
		this.recovery = r;
		this.laps = l;
	}
	//constructor
	
	public int getLaps()
	{
		return laps;
	}
	//getLaps
	
	public int getRecovery()
	{
		return recovery;
	}
	//getRecovery
	
	public String getEntry()
	{
		String result = getName()+" ran " + getLaps() + "X" + getDistance() + "m in"
	             +getHour()+":"+getMin()+":"+ getSec() + "with " + getRecovery() + " on "
	             +getDay()+"/"+getMonth()+"/"+getYear()+"\n" ;

	   return result;
	}
	//getEntry
}
	