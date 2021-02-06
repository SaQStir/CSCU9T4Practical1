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
    
    private JButton addR = new JButton("Add");
    private JButton lookUpByDate = new JButton("Look Up");
    private JButton FindAllByDate = new JButton("Find all by date");
    
    final String sprint = "SPRINT";
    final String run = "RUN";
    final String swim = "SWIM";
    final String cycle = "CYCLE";
    
    String[] activity = {sprint, run, swim, cycle};
    private JComboBox activities = new JComboBox<String> (activity);

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
        add(activities);
        activities.addActionListener(this);
        
        add(labn);
        add(name);
        name.setEditable(true);
        
        add(labd);
        add(day);
        day.setEditable(true);
        
        add(labm);
        add(month);
        month.setEditable(true);
        
        add(laby);
        add(year);
        year.setEditable(true);
        
        add(labh);
        add(hours);
        hours.setEditable(true);
        
        add(labmm);
        add(mins);
        mins.setEditable(true);
        
        add(labs);
        add(secs);
        secs.setEditable(true);
        
        add(labdist);
        add(dist);
        dist.setEditable(true);
        
        add(addR);
        addR.addActionListener(this);
        
        add(labter);
        add(terrain);
        labter.setVisible(false);
        terrain.setVisible(false);
        
        add(labtem);
        add(tempo);
        labtem.setVisible(false);
        tempo.setVisible(false);
        
        add(labloc);
        add(location);
        labloc.setVisible(false);
        tempo.setVisible(false);
        
        add(lablap);
        add(laps);
        lablap.setVisible(false);
        laps.setVisible(false);
        
        add(labrec);
        add(recovery);
        labrec.setVisible(false);
        recovery.setVisible(false);
        
        add(lookUpByDate);
        lookUpByDate.addActionListener(this);
        
        add(FindAllByDate);
        FindAllByDate.addActionListener(this);
        
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
        if (event.getSource() == addR) {
            message = addEntry("generic");
        }
        
        if (event.getSource() == lookUpByDate) {
            message = lookupEntry();
        }
        
        //Adding functionality to FindAllByDate
        if (event.getSource() == FindAllByDate)
        {
        	message = FindAllByDate();
        }
        
        if (event.getSource() == activities)
        {
        	String selected = (String) activities.getSelectedItem();
        	{
        		if(selected.equals("SPRINT"))
        		{
        			choice(true,false,false,false);
        		}
        		if(selected.equals("RUN"))
        		{
        			choice(false,true,false,false);
        		}
        		if(selected.equals("SWIM"))
        		{
        			choice(false,false,true,false);
        		}
        		if(selected.equals("CYCLE"))
        		{
        			choice(false,false,false,true);
        		}
        	}
        }
        
        outputArea.setText(message);
        blankDisplay();
    } 
    // actionPerformed

    public Boolean isValidNumber(String temp)
    {
    	boolean num = true;
    	try {
            Double tempNum = Double.parseDouble(temp);
        } catch (NumberFormatException e) {
            num = false;
        }
    	return num;
    }
    
    //UPDATE: 
    public String addEntry(String what) {
        String message = "Record added\n";
        System.out.println("Adding "+what+" entry to the records");
        String n = name.getText();
        int m;
        int d;
        int y;
        float km;
        int h;
        int mm;
        int s;
        if(isValidNumber(month.getText()) && isValidNumber(day.getText()) && isValidNumber(year.getText()) 
        		&& isValidNumber(dist.getText()) && isValidNumber(dist.getText()) 
        		&& isValidNumber(hours.getText()) && isValidNumber(mins.getText()) 
        		&& isValidNumber(secs.getText()))
        {
        	m = Integer.parseInt(month.getText());
            d = Integer.parseInt(day.getText());
            y = Integer.parseInt(year.getText());
            km = java.lang.Float.parseFloat(dist.getText());
            h = Integer.parseInt(hours.getText());
            mm = Integer.parseInt(mins.getText());
            s = Integer.parseInt(secs.getText());
            
            if(myAthletes.checkValidEntry(d,m,y,n))
            {
            	Entry e = new Entry(n, d, m, y, h, mm, s, km);
            	myAthletes.addEntry(e);
            }
            else 
            {
            	message = "this entry has already been recorded";
            }
        }
        else
        {
        	message = "invalid details date,time or distance format please use valid numbers";
        }
        return message;
    }
    
    public String lookupEntry() {
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        outputArea.setText("looking up record ...");
        String message = myAthletes.lookupEntry(d, m, y);
        return message;
    }
    
    //UPDATE: find all by date functionality
    public String FindAllByDate() 
    {
    	String message = myAthletes.AllEntries();
    	return message;
    }
    

    public void blankDisplay() {
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
    public void fillDisplay(Entry ent) {
        name.setText(ent.getName());
        day.setText(String.valueOf(ent.getDay()));
        month.setText(String.valueOf(ent.getMonth()));
        year.setText(String.valueOf(ent.getYear()));
        hours.setText(String.valueOf(ent.getHour()));
        mins.setText(String.valueOf(ent.getMin()));
        secs.setText(String.valueOf(ent.getSec()));
        dist.setText(String.valueOf(ent.getDistance()));
    }
    
    public void choice(boolean sprint, boolean run, boolean swim, boolean cycle)
    {
    	if(sprint)
    	{
    		lablap.setVisible(true);
            laps.setVisible(true);
            labrec.setVisible(true);
            recovery.setVisible(true);
            labtem.setVisible(false);
            tempo.setVisible(false);
            labter.setVisible(false);
            terrain.setVisible(false);
            labloc.setVisible(false);
            location.setVisible(false);
    	}
    	if(run)
    	{
    		lablap.setVisible(true);
            laps.setVisible(true);
            labrec.setVisible(false);
            recovery.setVisible(false);
            labtem.setVisible(false);
            tempo.setVisible(false);
            labter.setVisible(false);
            terrain.setVisible(false);
            labloc.setVisible(false);
            location.setVisible(false);
    	}
    	if(swim)
    	{
    		lablap.setVisible(false);
            laps.setVisible(false);
            labrec.setVisible(false);
            recovery.setVisible(false);
            labtem.setVisible(false);
            tempo.setVisible(false);
            labter.setVisible(false);
            terrain.setVisible(false);
            labloc.setVisible(true);
            location.setVisible(true);
    	}
    	if(cycle)
    	{
    		lablap.setVisible(false);
            laps.setVisible(false);
            labrec.setVisible(false);
            recovery.setVisible(false);
            labtem.setVisible(true);
            tempo.setVisible(true);
            labter.setVisible(true);
            terrain.setVisible(true);
            labloc.setVisible(false);
            location.setVisible(false);
    	}
    }
    
} // TrainingRecordGUI

