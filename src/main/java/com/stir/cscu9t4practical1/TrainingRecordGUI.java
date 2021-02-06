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
        getContentPane().setBackground(Color.LIGHT_GRAY);
        getContentPane().setLayout(null);
        labac.setBounds(12, 13, 49, 16);
        
        getContentPane().add(labac);
        labn.setBounds(152, 13, 42, 16);
        getContentPane().add(labn);
        labd.setBounds(12, 57, 30, 16);
        getContentPane().add(labd);
        labm.setBounds(75, 57, 44, 16);
        getContentPane().add(labm);
        laby.setBounds(152, 57, 35, 16);
        getContentPane().add(laby);
        labh.setBounds(12, 86, 42, 16);
        getContentPane().add(labh);
        labmm.setBounds(85, 86, 35, 16);
        getContentPane().add(labmm);
        labs.setBounds(152, 86, 36, 16);
        getContentPane().add(labs);
        labdist.setBounds(12, 118, 88, 16);
        getContentPane().add(labdist);
        name.setBounds(196, 10, 164, 22);
        
        getContentPane().add(name);
        day.setBounds(45, 54, 28, 22);
        getContentPane().add(day);
        month.setBounds(120, 54, 28, 22);
        getContentPane().add(month);
        year.setBounds(188, 54, 50, 22);
        getContentPane().add(year);
        hours.setBounds(55, 83, 28, 22);
        getContentPane().add(hours);
        mins.setBounds(120, 83, 28, 22);
        getContentPane().add(mins);
        secs.setBounds(194, 83, 28, 22);
        getContentPane().add(secs);
        dist.setBounds(100, 115, 50, 22);
        getContentPane().add(dist);
        addR.setBounds(45, 254, 74, 25);
        getContentPane().add(addR);
        lookUpByDate.setBounds(150, 254, 88, 25);
        getContentPane().add(lookUpByDate);
        FindAllByDate.setSize(119, 25);
        FindAllByDate.setLocation(327, 254);
        getContentPane().add(FindAllByDate);
        
        name.setEditable(true);
        day.setEditable(true);
        month.setEditable(true);        
        year.setEditable(true);
        hours.setEditable(true);
        mins.setEditable(true);
        secs.setEditable(true);
        dist.setEditable(true);
        activitiesList.setBounds(65, 10, 70, 22);
        
        getContentPane().add(activitiesList);
        labter.setBounds(302, 86, 51, 16);
        
        getContentPane().add(labter);
        labtem.setBounds(302, 57, 49, 16);
        getContentPane().add(labtem);
        labloc.setBounds(302, 57, 53, 16);
        getContentPane().add(labloc);
        lablap.setBounds(302, 57, 27, 16);
        getContentPane().add(lablap);
        labrec.setBounds(302, 86, 89, 16);
        getContentPane().add(labrec);
        terrain.setBounds(364, 83, 50, 22);
        
        getContentPane().add(terrain);
        tempo.setBounds(354, 54, 50, 22);
        getContentPane().add(tempo);
        location.setBounds(354, 54, 50, 22);
        getContentPane().add(location);
        laps.setBounds(335, 54, 50, 22);
        getContentPane().add(laps);
        recovery.setBounds(396, 83, 50, 22);
        getContentPane().add(recovery);
        
        labter.setVisible(false);
        labtem.setVisible(false);
        labloc.setVisible(false);
        lablap.setVisible(false);
        labrec.setVisible(false);
        
        terrain.setVisible(false);
        tempo.setVisible(false);
        laps.setVisible(false);
        recovery.setVisible(false);
        location.setVisible(false);
        
        addR.addActionListener(this);
        lookUpByDate.addActionListener(this);
        FindAllByDate.addActionListener(this);
        activitiesList.addActionListener(this);
        outputArea.setBounds(55, 147, 391, 94);
        outputArea.setEditable(false);
        
        
        getContentPane().add(outputArea);
        setSize(525, 395);
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
    	
    	if(!myAthletes.checkValidEntry(d,m,y,n))
    	{
    		return "Entry has already been recorded";
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

