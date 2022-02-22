package Selectfilepackage;

import java.awt.*;
import java.awt.event.*;
import Encopack.Enco;
import Commands.Commands;

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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
//import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class SelectFile implements ActionListener{

    JFrame frame = new JFrame("FILE SELECTION");
    JPanel panel2;
    JLabel displayOut, fileresult;
    JButton filnam, yes, no;
    JTextField flnmtf;
    boolean newfile = false;

    public SelectFile(){
        //System.out.println("ffffffff");
            panel2 = new JPanel();
            frame.setSize(900, 600);
            frame.setLocation(150, 150);
            panel2.setBackground(Color.black);
            frame.getContentPane();
    
            displayOut = new JLabel();
            displayOut.setText("Select your file name along with extension");
            displayOut.setFont(new Font("Courier New", Font.BOLD, 20));
            displayOut.setBackground(Color.black);
            displayOut.setForeground(Color.white);
            displayOut.setBounds(200, 100, 600, 40);
            panel2.add(displayOut);
            panel2.setLayout(null);

            fileresult = new JLabel("", SwingConstants.CENTER);
            fileresult.setFont(new Font("Courier New", Font.PLAIN, 20));
            fileresult.setBackground(Color.black);
            fileresult.setForeground(Color.gray);
            fileresult.setBounds(270, 185, 400, 30);
            panel2.add(fileresult);
    
            filnam = new JButton("SUBMIT");
            filnam.setFont(new Font("Courier New", Font.BOLD, 30));
            filnam.setBounds(375, 375, 150, 30);
            filnam.addActionListener(this);
            panel2.add(filnam);

            yes = new JButton("Yes");
            yes.setFont(new Font("Courier New", Font.BOLD, 20));
            yes.setBounds(350, 235, 80, 30);
            yes.addActionListener(this);
            yes.setVisible(false);
            panel2.add(yes);

            no = new JButton("No");
            no.setFont(new Font("Courier New", Font.BOLD, 20));
            no.setBounds(430, 235, 80, 30);
            no.addActionListener(this);
            no.setVisible(false);
            panel2.add(no);
    
            flnmtf = new JTextField();
            flnmtf.setFont(new Font("Courier New", Font.ITALIC, 20));
            flnmtf.setBounds(300, 150, 300, 25);
            panel2.add(flnmtf);
            frame.add(panel2);

            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setSize(900, 600);
            frame.setLocation(150, 150);
            frame.setVisible(true);
        }
    
    
    
    public static void main (String[] args){
        new SelectFile();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        String flnm = flnmtf.getText();

        if (e.getSource() == filnam){
            if (Enco.Selcfile(flnm, false) && !(flnm.isEmpty())){
                displayOut.setForeground(Color.green);
                fileresult.setText("File Retrieved Successfully");
                frame.dispose();
                new Commands();
            }else{
                displayOut.setForeground(Color.red);
                fileresult.setText("File not Found, Create new File?");
                yes.setVisible(true);
                no.setVisible(true);
            }
        }

        else if (e.getSource() == yes){
            Enco.Selcfile(flnm, true);
            frame.dispose();
            new Commands();
        }
    }

    
}
