/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.managment.system;

/**
 *
 * @author Hari Ram
 */

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.Font;
import javax.swing.*;
import java.awt.Image;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.*;
import java.awt.event.*;
public class About extends JFrame   {
    

    JButton b2;
   
    About(){
        
        JLabel l1 = new JLabel("Developer");
        l1.setFont(new Font("Tahoma",Font.PLAIN,20));
        l1.setForeground(Color.BLUE);
        l1.setBounds(100,20,200,30);
        add(l1);
        
        JLabel l2 = new JLabel("Hari Ram.R (19MX106)");
        l2.setForeground(Color.RED);
        l2.setBounds(30,80,200,30);
        add(l2);
       
        JLabel l3 = new JLabel("MCA 3RD SEM");
        l3.setForeground(Color.RED);
        l3.setBounds(30,130,200,30);
        add(l3);
        
        JLabel l4 = new JLabel("Java PACKAGE");
        l4.setForeground(Color.RED);
        l4.setBounds(30,180,200,30);
        add(l4);
        
        
        
   getContentPane().setBackground(Color.WHITE);
       
    ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("hotel/managment/system/icons/JAVA.jpg"));
   Image i5 = i4.getImage().getScaledInstance(400,250, Image.SCALE_DEFAULT);
    ImageIcon i6 = new ImageIcon(i5);
    JLabel l5 = new JLabel(i4);
    l5.setBounds(350,0,400,250);
    add(l5);
    
    
    
        setLayout(null);
        setBounds(500,200,800,300);
        setVisible(true);
    
}
    
 public static void main(String[] args){
        new About().setVisible(true);
    }   
}

           
             
       