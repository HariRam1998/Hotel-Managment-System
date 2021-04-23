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
public class CheckOut extends JFrame implements ActionListener {
    
    JTextField t1;
    JButton b1,b2,b3;
    Choice c1;
    CheckOut(){
        
        JLabel l1 = new JLabel("Check Out");
        l1.setFont(new Font("Tahoma",Font.PLAIN,20));
        l1.setForeground(Color.BLUE);
        l1.setBounds(100,20,100,30);
        add(l1);
        
        JLabel l2 = new JLabel("Customer -ID");
        l2.setForeground(Color.BLUE);
        l2.setBounds(30,80,100,30);
        add(l2);
        
        c1 = new Choice();
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while(rs.next()){
                c1.add(rs.getString("number"));
            }
        }catch(Exception e){}
        
        c1.setBounds(150,80,150,30);
        add(c1); 
        
         t1=new JTextField();
        t1.setBounds(150,130,150,30);
        add(t1);
        
        JLabel l3 = new JLabel("Room Number");
        l3.setForeground(Color.BLUE);
        l3.setBounds(30,130,100,30);
        add(l3);
        
        b1 = new JButton("Check Out");
        b1.setBounds(30,200,120,30);
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Back");
        b2.setBounds(170,200,120,30);
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        b2.addActionListener(this);
        add(b2);
        
        
        
   getContentPane().setBackground(Color.WHITE);
        
   ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/managment/system/icons/tick.png"));
   Image i2 = i1.getImage().getScaledInstance(20,20, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    b3 = new JButton(i3);
    b3.setBounds(310,80,20,20);
    b3.addActionListener(this);
    add(b3);
    
    ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("hotel/managment/system/icons/sixth.jpg"));
   Image i5 = i4.getImage().getScaledInstance(400,250, Image.SCALE_DEFAULT);
    ImageIcon i6 = new ImageIcon(i5);
    JLabel l4 = new JLabel(i4);
    l4.setBounds(350,0,400,250);
    add(l4);
    
    
    
        setLayout(null);
        setBounds(500,200,800,300);
        setVisible(true);
    
}
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==b1){
         String id = c1.getSelectedItem();
         String room = t1.getText();
         String str = "delete from customer where number = '"+id+"'";
         String str2 = "update room set availability = 'Available' where room_number = '"+room+"'";
         try{
         conn c =  new conn();
         int amountPaid,elf=0;
         String deposit=null,price;
             ResultSet rs = c.s.executeQuery("Select * from customer where number = '"+id+"'");
             while(rs.next()){
                 deposit = rs.getString("deposit");
             }
             
             ResultSet rs2 = c.s.executeQuery("Select * from room where room_number = '"+room+"'");
             while(rs2.next()){
                 
                 price = rs2.getString("price");
                 amountPaid = Integer.parseInt(price) - Integer.parseInt(deposit);
                 if(amountPaid != 0){
             JOptionPane.showMessageDialog(null, "Balace is remaining!!!");
             elf = 1;
}
             }
         if (elf == 0){
         try{

             c.s.executeUpdate(str);
             c.s.executeUpdate(str2);
             JOptionPane.showMessageDialog(null, "Checkout Done");
             new Reception().setVisible(true);
             this.setVisible(false);   
         }catch(Exception e){
             System.out.println(e);
         }}
         }catch(Exception e){
             
         }
        }else if(ae.getSource() == b2){
            new Reception().setVisible(true);
          this.setVisible(false); 
        }else if(ae.getSource() == b3){
            conn c =new conn();
            String id = c1.getSelectedItem();
            try{
              ResultSet rs = c.s.executeQuery("select * from customer where number = '"+id+"'");
              while(rs.next()){
                 t1.setText(rs.getString("room_number"));
             }
            }catch(Exception e){}
        }
        
        
    }
 public static void main(String[] args){
        new CheckOut().setVisible(true);
    }   
}

           
             
       