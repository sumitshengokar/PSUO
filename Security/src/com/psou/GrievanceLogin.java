package com.psou;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GrievanceLogin extends JFrame {

    Button submit, cancel;
    TextField PNR;
    TextArea title, desc;
    Label lb_PNR, lb_title, lb_desc;
    Frame Grievance;
    Color blue = new Color(51,122,183);
    Color white = new Color(255, 255, 255);
    GrievanceLogin() {


        Grievance=renderGrievanceLogin();
        Grievance.setLayout(null);
        Grievance.setVisible(true);
    }
    public Frame renderGrievanceLogin(){
        Frame Gr_login;
        Dimension d = new Dimension(50,100);
        Gr_login = new Frame("Grievance Window");
        Gr_login.setBackground(white);
        Gr_login.setSize(500,500);
        Gr_login.setResizable(false);

        lb_PNR = new Label("Enter PNR or Ticket Number :");
        lb_PNR.setBounds(80, 50, 160, 30);
        Gr_login.add(lb_PNR);

        PNR = new TextField();
        PNR.setBounds(280, 50, 130, 30);
        Gr_login.add(PNR);


        lb_title = new Label("Enter Title :");
        lb_title.setBounds(80, 90, 100, 50);
        Gr_login.add(lb_title);

        title = new TextArea(10,50);
        title.setBounds(280, 100, 200, 50);
        Gr_login.add(title);

        lb_desc = new Label("Enter Description :");
        lb_desc.setBounds(80, 170, 100, 50);
        Gr_login.add(lb_desc);

        desc = new TextArea(10,50);

        desc.setBounds(280, 180, 200, 100);
        Gr_login.add(desc);
        submit = new Button("Submit");
        submit.setBounds(130, 400, 100, 30);
        Gr_login.add(submit);
        submit.setBackground(blue);

        cancel = new Button("Cancel");
        cancel.setBounds(270, 400, 100, 30);
        Gr_login.add(cancel);
        cancel.setBackground(blue);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter("complaints.txt",true));
                    String Pnr=PNR.getText();
                    writer.write(Pnr+"#\n");
                    String t=title.getText();
                    writer.write(t+"@\n");
                    String de=desc.getText();
                    writer.write(de+"$\n");
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                HomePage frame = new HomePage();
                frame.setVisible(true);
                //set default close operation
                Gr_login.dispose();
                setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
            	HomePage frame = new HomePage();
                frame.setVisible(true);
                //set default close operation
                Gr_login.dispose();
                setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                //System.exit(0);
            }
        });


        Gr_login.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        return  Gr_login;

    }




}

