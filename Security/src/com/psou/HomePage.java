package com.psou;//import statement
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class HomePage extends JFrame {

    static HomePage frame;
    JButton complaint_btn, exit_btn, staff_btn, disp_btn;
    Color blue = new Color(51,122,183);
    Color white = new Color(255, 255, 255);
    JTextField t1;
    JTextArea title, desc;
    JLabel lb_PNR, lb_title, lb_desc;
    private JPanel contentPane;

    public static void main(String[] args)
    {

        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {

                try
                {
                     frame = new HomePage();
                    frame.setVisible(true);
                    frame.setResizable(false);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
    }

    public HomePage()
    {
        setTitle("HomePage");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 500, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setBackground(white);
        contentPane.setLayout(null);
        contentPane.setAlignmentY(Component.CENTER_ALIGNMENT);
        contentPane.setAlignmentX(Component.CENTER_ALIGNMENT);

        complaint_btn = new JButton("Lodge A Complaint");
        complaint_btn.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
        complaint_btn.setBounds( 100,150,294, 32);
        complaint_btn.setBackground(blue);

        contentPane.add(complaint_btn);


        complaint_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                GrievanceLogin grievanceLogin=new GrievanceLogin();
                grievanceLogin.setVisible(true);
                frame.dispose();
                setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });
        
        staff_btn = new JButton("Staff");
        staff_btn.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
        staff_btn.setBounds(100,80,290, 32);
        staff_btn.setBackground(blue);
        
        contentPane.add(staff_btn);
        
        staff_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Schedule schedule=new Schedule();
                schedule.setVisible(true);
                frame.dispose();
                setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });
        
        exit_btn = new JButton("Exit");
        exit_btn.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
        exit_btn.setBounds( 100,300,294, 32);
        exit_btn.setBackground(blue);
        contentPane.add(exit_btn);

        exit_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });


    }

}