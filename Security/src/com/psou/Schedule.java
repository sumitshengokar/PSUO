package com.psou;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Schedule extends JFrame{
	Button submit, cancel;
	JRadioButton b1, b2, b3;
	ButtonGroup G;
    TextField Name, Phone;
    Label lb_name, lb_phone;
    Frame Schedule;
    JTable table;
    Color blue = new Color(51,122,183);
    Color white = new Color(255, 255, 255);
    Schedule() {

        Schedule=renderSchedule();
        Schedule.setLayout(null);
        Schedule.setVisible(true);
    }
    public Frame renderSchedule() {
    	Frame sched;
        Dimension d = new Dimension(50,100);
        sched = new Frame("Schedule Window");
        sched.setBackground(white);
        sched.setSize(500,250);
        sched.setResizable(false);
        
        lb_name = new Label("Enter Name :");
        lb_name.setBounds(80, 50, 80, 30);
        sched.add(lb_name);
        
        lb_phone = new Label("Enter Phone :");
        lb_phone.setBounds(80, 90, 80, 30);
        sched.add(lb_phone);
        
        Name = new TextField();
        Name.setBounds(200, 50, 230, 30);
        sched.add(Name);
        
        Phone = new TextField();
        Phone.setBounds(200, 90, 230, 30);
        sched.add(Phone);
        
        G = new ButtonGroup();
        
        b1 = new JRadioButton("Pantry");
        b1.setBounds(80, 130, 80, 30);
        sched.add(b1);
        b1.setBackground(white);
        
        b2 = new JRadioButton("TC");
        b2.setBounds(180, 130, 80, 30);
        sched.add(b2);
        b2.setBackground(white);
        
        b3 = new JRadioButton("Cleaning");
        b3.setBounds(280, 130, 80, 30);
        sched.add(b3);
        b3.setBackground(white);
        
        G.add(b1);
        G.add(b2);
        G.add(b3);
        
        submit = new Button("Submit");
        submit.setBounds(130, 160, 100, 30);
        sched.add(submit);
        submit.setBackground(blue);
       
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                	if(b1.isSelected()) {
                		BufferedWriter writer = new BufferedWriter(new FileWriter("Pantry.txt",true));
                		String Nam = Name.getText();
                		writer.write(Nam+"\n");
                		String Ph = Phone.getText();
                		writer.write(Ph+"\n");
                		writer.close();
                	}
                	else if(b1.isSelected()) {
                		BufferedWriter writer = new BufferedWriter(new FileWriter("TC.txt",true));
                        String Nam = Name.getText();
                        writer.write(Nam+"\n");
                        String Ph = Phone.getText();
                        writer.write(Ph+"\n");
                        writer.close();
                	}
                	else if(b1.isSelected()) {
                		BufferedWriter writer = new BufferedWriter(new FileWriter("Cleaning.txt",true));
                        String Nam = Name.getText();
                        writer.write(Nam+"\n");
                        String Ph = Phone.getText();
                        writer.write(Ph+"\n");
                        writer.close();
                	}
                	else {
                		JOptionPane.showMessageDialog(Schedule.this, "Select An Option");
                	}
                } catch (IOException e) {
                    e.printStackTrace();
                }
                HomePage frame = new HomePage();
                frame.setVisible(true);
                //set default close operation
                sched.dispose();
                setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });
        
        cancel = new Button("Cancel");
        cancel.setBounds(270, 160, 100, 30);
        sched.add(cancel);
        cancel.setBackground(blue);
        
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
            	HomePage frame = new HomePage();
                frame.setVisible(true);
                //set default close operation
                sched.dispose();
                setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                //System.exit(0);
            }
        });
        
        sched.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
        return sched;
    }
}
