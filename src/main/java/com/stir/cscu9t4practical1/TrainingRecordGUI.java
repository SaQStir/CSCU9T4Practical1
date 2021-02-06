// GUI and main program for the Training Record
//package com.stir.cscu9t4practical1;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.Number;

public class TrainingRecordGUI extends JFrame implements ActionListener {

    private JTextField name = new JTextField(30);
    private JTextField day = new JTextField(2);
    private JTextField month = new JTextField(2);
    private JTextField year = new JTextField(4);
    private JTextField hours = new JTextField(2);
    private JTextField mins = new JTextField(2);
    private JTextField secs = new JTextField(2);
    private JTextField dist = new JTextField(4);
    private JTextField terrain = new JTextField(4);
    private JTextField tempo = new JTextField(4);
    private JTextField location = new JTextField(4);
    private JTextField laps = new JTextField(4);
    private JTextField recovery = new JTextField (4);
    
    private JLabel labn = new JLabel(" Name:");
    private JLabel labd = new JLabel(" Day:");
    private JLabel labm = new JLabel(" Month:");
    private JLabel laby = new JLabel(" Year:");
    private JLabel labh = new JLabel(" Hours:");
    private JLabel labmm = new JLabel(" Mins:");
    private JLabel labs = new JLabel(" Secs:");
    private JLabel labac = new JLabel(" Activity:");
    private JLabel labdist = new JLabel(" Distance (km):");
    private JLabel labter = new JLabel(" Terrain:");
    private JLabel labtem = new JLabel(" Tempo:");
    private JLabel labloc = new JLabel(" location:");
    private JLabel lablap = new JLabel(" laps");
    private JLabel labrec = new JLabel(" recovery(min):");
    
    private String[] Activities = {"SPRINT", "RUN", "CYCLE", "SWIM"};
    
    JComboBox activitiesList = new JComboBox(Activities);
    
    private JButton addR = new JButton("Add");
    private JButton lookUpByDate = new JButton("Look Up");
    private JButton FindAllByDate = new JButton("Find all by date");

    private TrainingRecord myAthletes = new TrainingRecord();

    private JTextArea outputArea = new JTextArea(5, 50);

    public static void main(String[] args) {
        TrainingRecordGUI applic = new TrainingRecordGUI();
    } // main

    // set up the GUI 
    public TrainingRecordGUI() {
        super("Training Record");
        setLayout(new FlowLayout());
        
        add(labac);
        add(labn);
        add(labd);
        add(labm);
        add(laby);
        add(labh);
        add(labmm);
        add(labs);
        add(labdist);
        
        add(name);
        add(day);
        add(month);
        add(year);
        add(hours);
        add(mins);
        add(secs);
        add(dist);
        add(addR);
        add(lookUpByDate);
        
        name.setEditable(true);
        day.setEditable(true);
        month.setEditable(true);        
        year.setEditable(true);
        hours.setEditable(true);
        mins.setEditable(true);
        secs.setEditable(true);
        dist.setEditable(true);
        
        add(activitiesList);
        
        getContentPane().add(labter);
        getContentPane().add(labtem);
        getContentPane().add(labloc);
        getContentPane().add(lablap);
        getContentPane().add(labrec);
        
        getContentPane().add(terrain);
        getContentPane().add(tempo);
        getContentPane().add(location);
        getContentPane().add(laps);
        getContentPane().add(recovery);
        
        labter.setVisible(false);
        terrain.setVisible(false);
        labtem.setVisible(false);
        tempo.setVisible(false);
        labloc.setVisible(false);
        tempo.setVisible(false);
        lablap.setVisible(false);
        laps.setVisible(false);
        labrec.setVisible(false);
        recovery.setVisible(false);
        
        addR.addActionListener(this);
        lookUpByDate.addActionListener(this);
        FindAllByDate.addActionListener(this);
        activitiesList.addActionListener(this);
        
        
        add(outputArea);
        outputArea.setEditable(false);
        setSize(720, 200);
        setVisible(true);
        blankDisplay();

        // To save typing in new entries while testing, uncomment
        // the following lines (or add your own test cases)
        
    } // constructor

    // listen for and respond to GUI events 
    public void actionPerformed(ActionEvent event) 
    {
        String message = "";
        if (event.getSource() == addR) 
        {
            message = addEntry("generic");
        }
        
        if (event.getSource() == lookUpByDate) 
        {
            message = lookupEntry();
        }
        
        if (event.getSource() == FindAllByDate)
        {
        	message = FindAllByDate();
        }
        
        if (event.getSource() == activitiesList)
        {
        	if(activitiesList.getSelectedItem().equals("SPRINT"))
        	{
        		selectItem("SPRINT");
        	}
        	if(activitiesList.getSelectedItem().equals("RUN"))
        	{
        		selectItem("RUN");
        	}
        	if(activitiesList.getSelectedItem().equals("CYCLE"))
        	{
        		selectItem("CYCLE");
        	}
        	if(activitiesList.getSelectedItem().equals("SWIM"))
        	{
        		selectItem("SWIM");
        	}
        }
        
        outputArea.setText(message);
        blankDisplay();
        
    } // actionPerformed

    public String addEntry(String what) 
    {
    	String message = "Record added\n";
        System.out.println("Adding "+what+" entry to the records");
        
        String sport = (String) activitiesList.getSelectedItem();
        
        String n = name.getText();
    	int d = tryParseInt(day.getText());
    	int m = tryParseInt(month.getText());
    	int y = tryParseInt(year.getText());
    	float km = tryParseFloat(dist.getText());
    	int h = tryParseInt(hours.getText());
    	int mm = tryParseInt(mins.getText());
    	int s = tryParseInt(secs.getText());
    	
    	if(n.isEmpty())
    	{
    		return "Name field empty";
    	}
    	if(d == -1 || m == -1 || y == -1)
    	{
    		return "Incorect date format please use numbers";
    	}
    	
    	if(km == -1)
    	{
    		return "Distance value invalid";
    	}
    	
    	if(h == -1 || mm == -1 || s == -1)
    	{
    		return "Incorect time format make sure all fields correct";
    	}
    	
    	
        Entry e = new Entry(n, d, m, y, h, mm, s, km);
        myAthletes.addEntry(e);
        return message;
    }
    
    public String lookupEntry() 
    {
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        outputArea.setText("looking up record ...");
        String message = myAthletes.lookupEntry(d, m, y);
        return message;
    }

    public void blankDisplay() 
    {
        name.setText("");
        day.setText("");
        month.setText("");
        year.setText("");
        hours.setText("");
        mins.setText("");
        secs.setText("");
        dist.setText("");

    }// blankDisplay
    // Fills the input fields on the display for testing purposes only
    public void fillDisplay(Entry ent) 
    {
        name.setText(ent.getName());
        day.setText(String.valueOf(ent.getDay()));
        month.setText(String.valueOf(ent.getMonth()));
        year.setText(String.valueOf(ent.getYear()));
        hours.setText(String.valueOf(ent.getHour()));
        mins.setText(String.valueOf(ent.getMin()));
        secs.setText(String.valueOf(ent.getSec()));
        dist.setText(String.valueOf(ent.getDistance()));
    }
    
    public String FindAllByDate()
    {
    	String message = myAthletes.AllEntries();
    	return message;
    }
    
    public static Integer tryParseInt(String n)
    {
    	try
    	{
    		return Integer.parseInt(n);
    	}
    	catch(NumberFormatException ex)
    	{
    		return -1;
    	}
    }
    
    public static Float tryParseFloat(String n)
    {
    	try
    	{
    		return Float.parseFloat(n);
    	}
    	catch(NumberFormatException ex)
    	{
    		return (float) -1;
    	}
    }
    
    public void selectItem(String a)
    {
    	if(a.equals("SPRINT"))
    	{
    		hideAll();
    		lablap.setVisible(true);
            laps.setVisible(true);
            labrec.setVisible(true);
            recovery.setVisible(true);
    	}
    	
    	if(a.equals("RUN"))
    	{
    		hideAll();
    		lablap.setVisible(true);
    		laps.setVisible(true);
    	}
    	
    	if(a.equals("CYCLE"))
    	{
    		hideAll();
    		labtem.setVisible(true);
            tempo.setVisible(true);
            labter.setVisible(true);
            terrain.setVisible(true);
    	}
    	
    	if(a.equals("SWIM"))
    	{
    		hideAll();
    		labloc.setVisible(true);
            location.setVisible(true);
    	}
    }
    
    public void hideAll()
    {
    	lablap.setVisible(false);
        laps.setVisible(false);
        labrec.setVisible(false);
        recovery.setVisible(false);
        labtem.setVisible(false);
        tempo.setVisible(false);
        labter.setVisible(false);
        terrain.setVisible(false);
        labloc.setVisible(false);
        location.setVisible(false);
    }

} // TrainingRecordGUI

