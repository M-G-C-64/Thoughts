package Commands;

import java.awt.*;
import java.awt.event.*;
import java.nio.file.Path;

//import Encopack.Enco;
import newEntryJava.newEntryJava;

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
//import javax.swing.JTextField;
//import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import Encopack.Enco;

public class Commands implements ActionListener{

    JFrame Commjf = new JFrame();
    JPanel panel3 = new JPanel();
    JLabel title;
    JButton newEntry, Reveal, Exit;
    Path datapathP;

    public Commands(Path dataPath){

        datapathP = dataPath;

        panel3 = new JPanel();
        panel3.setBackground(Color.black);
        Commjf.getContentPane();
        panel3.setLayout(null);

        newEntry = new JButton("New Entry");
        newEntry.setFont(new Font("Courier New", Font.BOLD, 20));
        newEntry.setBounds(50, 50, 200, 30);
        newEntry.addActionListener(this);
        panel3.add(newEntry);

        Reveal = new JButton("Reveal");
        Reveal.setFont(new Font("Courier New", Font.BOLD, 20));
        Reveal.setBounds(50, 100, 200, 30);
        Reveal.addActionListener(this);
        panel3.add(Reveal);

        Exit = new JButton("Exit");
        Exit.setFont(new Font("Courier New", Font.BOLD, 20));
        Exit.setBounds(50, 150, 200, 30);
        Exit.addActionListener(this);
        panel3.add(Exit);

        Commjf.add(panel3);
        Commjf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Commjf.setSize(300, 600);
        Commjf.setLocation(150, 150);
        Commjf.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() == newEntry){
            Commjf.dispose();
            new newEntryJava(datapathP);
        }

        if (e.getSource() == Reveal){
            Commjf.dispose();
            Enco.showgui(datapathP);
        }

        if (e.getSource() == Exit){
            Commjf.dispose();
        }
    }

    public static void main (String[] args){
        //new Commands(datapath);
    }
    
}
