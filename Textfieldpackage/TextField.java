package Textfieldpackage;

import java.awt.*;
import java.awt.event.*;

import Selectfilepackage.SelectFile;
import Encopack.Enco;


/*
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.security.DigestException;
import java.util.ArrayList;
import java.util.Scanner;*/

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
//import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

//import org.w3c.dom.Text;

public class TextField implements ActionListener{

    JTextField JtfPass, flnmtf;
    JButton submit, filnam;
    JLabel displayOut;
    JFrame frame;
    JPanel panel, panel2;

    TextField(){

        frame = new JFrame("Enco");

        JtfPass = new JTextField();
        JtfPass.setBounds(250, 140, 200, 20);

        submit = new JButton("SUBMIT");
        submit.setBounds(460, 140, 80, 20);
        submit.addActionListener(this);

        panel = new JPanel();
        panel.setBackground(Color.DARK_GRAY);
        frame.getContentPane();

        displayOut = new JLabel("");
        displayOut.setOpaque(true);
        displayOut.setFont(new Font("Courier New", Font.BOLD, 40));
        displayOut.setBackground(Color.DARK_GRAY);
        
        //Dimension size1 = displayOut.getPreferredSize();
        displayOut.setBounds(235, 300, 400, 40);
        panel.add(displayOut);
        
        JLabel label = new JLabel("Greetings! Authentication Required.");
        label.setOpaque(true);
        label.setFont(new Font("Verdana", Font.BOLD, 20));
        label.setBackground(Color.DARK_GRAY);
        label.setForeground(Color.white);

        Dimension size = label.getPreferredSize();
        label.setBounds(200, 100, size.width, size.height);

        //JTextField Tf = new JTextField();
        //Tf.setBounds(300, 200, 200, 20);

        panel.setLayout(null);
        panel.add(label);
        //panel.add(Tf);

        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //add to panel and then add to frame
        panel.add(JtfPass);
        //panel.add(Outcome);
        panel.add(submit);
        panel.add(displayOut);
        frame.add(panel);

        frame.setSize(800, 500);
        frame.setLocation(200, 200);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed (ActionEvent e){
        String inpPass = JtfPass.getText();
        
        if (e.getSource() == submit){
            //Enco enc = new Enco();
            
            if (Enco.PassCheck(inpPass)){
                //Outcome.setBorder(BorderFactory.createLineBorder(Color.green));
                //Outcome.setText("WELCOME");

                displayOut.setText("Access Granted");
                displayOut.setForeground(Color.green);
                
                frame.dispose();
                new SelectFile();
                
            }else{
                //Outcome.setText("Pft skiddadle");
                //Outcome.setBorder(BorderFactory.createLineBorder(Color.red));

                displayOut.setText("Access Denied");
                displayOut.setForeground(Color.red);

            }
        }
    
    }
    

    public static void main (String[] args){
        new TextField();
    }
}