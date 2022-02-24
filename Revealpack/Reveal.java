package Revealpack;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
//import javax.swing.JTextField;
//import javax.swing.SwingConstants;
//import javax.swing.WindowConstants;

public class Reveal implements ActionListener{

    JFrame frame = new JFrame("New Entry");
    JPanel panel = new JPanel(new GridBagLayout());
    JPanel panel2 = new JPanel(new GridBagLayout());
    JLabel EnterYourThought;
    JTextArea textArea;
    JButton back;
    Path datapathP;

    public Reveal(BufferedReader br, Path datapath){

        datapathP = datapath;

        frame = new JFrame("ScrollPane to TextArea");
        frame.setLocation(200, 200);
        //frame.setSize(900, 600);
        frame.setResizable(false);


        textArea = new JTextArea(20, 80); //Rows and cols to be displayed
        textArea.setLineWrap(true);
        textArea.setBackground(Color.DARK_GRAY);
        textArea.setForeground(Color.WHITE);
        textArea.setFont(new Font("Courier New", Font.PLAIN, 20));
        JScrollPane scroll = new JScrollPane(textArea);
        //scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        
        try
        {
            FileReader fread = new FileReader(datapath.toString());
            BufferedReader bread = new BufferedReader(fread);

            String buff;
            while ((buff = bread.readLine()) != null){
                textArea.append(Enco.decod(buff)+"\n");
            }
            bread.close();
            fread.close();

        }catch(IOException e){
            e.printStackTrace();
        }

        /*
        newEntry.setSize(900, 600);
        newEntry.setLocation(150, 150);
        panel4.setBackground(Color.black);
        newEntry.getContentPane();
        panel4.setLayout(null);*/

        EnterYourThought = new JLabel();
        EnterYourThought.setText("These are your messages.");
        //EnterYourThought.setBounds(100, 500, 400, 30);
        EnterYourThought.setFont(new Font("Courier New", Font.PLAIN, 20));
        EnterYourThought.setBackground(Color.BLACK);
        EnterYourThought.setForeground(Color.WHITE);
        panel.add(EnterYourThought);
        

        back = new JButton();
        back.setFont(new Font("Courier New", Font.BOLD, 20));
        back.setText("Back");
        //back.setBounds(100, 550, 200, 30);
        back.addActionListener(this);
        panel.add(back);

        /*
        newEntry.add(panel5);
        newEntry.add(panel4);
        newEntry.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        newEntry.setSize(900, 600);
        newEntry.setLocation(150, 150);
        newEntry.setVisible(true);*/

        
        panel.setBackground(Color.black);
        panel.add(scroll);


        GridBagConstraints gc = new GridBagConstraints();

        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.weightx = 1;
        gc.gridx = 0;
        gc.gridy = 1;
        panel.add(scroll, gc);

        GridBagConstraints gc2 = new GridBagConstraints();

        gc2.fill = GridBagConstraints.HORIZONTAL;
        gc2.weightx = 1;
        gc2.gridx = 0;
        gc2.gridy = 0;
        gc2.ipadx = 10;
        panel2.add(back, gc2);

        frame.add(panel, BorderLayout.CENTER); //We add the scroll, since the scroll already contains the textArea
        frame.add(panel2, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() == back){
            frame.dispose();
            new Commands(datapathP);
        }
    }

    public static void main (String[] args){
        //new newEntryJava();
    }
    
}
