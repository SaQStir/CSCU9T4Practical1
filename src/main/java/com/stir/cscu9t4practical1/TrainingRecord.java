// An implementation of a Training Record as an ArrayList
//package com.stir.cscu9t4practical1;




import java.util.*;


public class TrainingRecord {
    private List<Entry> tr;
    
    
    public TrainingRecord() {
        tr = new ArrayList<Entry>();
    } //constructor
   
    
    // add a record to the list
   public void addEntry(Entry e){
       tr.add(e);    
   } // addClass
   
   
   // look up the entry of a given day and month
   public String lookupEntry (int d, int m, int y) 
   {
       ListIterator<Entry> iter = tr.listIterator();
       String result = "";
       while (iter.hasNext()) 
       {
          Entry current = iter.next();
          //UPDATE:Now adding to string result if additional entries found on same day
          if (current.getDay()==d && current.getMonth()==m && current.getYear()==y) 
             result = result + "\n" + current.getEntry(); 
          //UPDATE:if !result result = "No entries found"
       }	
       	  if (result == "")
       	  {
       		  result = "No entries found"; 
       	  }
       return result;
   } // lookupEntry
   
   
   //UPDATE: used to check if entry is already input Challenge 4
   //checking if entry is already existant in database
   public boolean checkValidEntry(int d, int m, int y, String n) 
   {
       ListIterator<Entry> iter = tr.listIterator();
       boolean result = true;
       while (iter.hasNext()) 
       {
          Entry current = iter.next();   
          
          if (current.getDay()==d && current.getMonth()==m && current.getYear()==y && current.getName().equals(n)) 
          {
        	  result = false;
          }  
       }
       return result;
   } // checkValidEntry
     
   
    //UPDATE:return all previously entered entries
   public String AllEntries()
   {
	   ListIterator<Entry> iter = tr.listIterator();
	   String list = "";
	   while (iter.hasNext())
	   {
		   Entry current = iter.next();
		   list = list + "\n" + current.getEntry();
	   }
	   if(list == "")
	   {
		   list = "No entries found";
	   }
	   return list;
   }
   // FindAllByDate
   
   
   // Count the number of entries
   public int getNumberOfEntries()
   {
       return tr.size();
   }
   
   
   // Clear all entries
   public void clearAllEntries()
   {
       tr.clear();
   }
   
} // TrainingRecord