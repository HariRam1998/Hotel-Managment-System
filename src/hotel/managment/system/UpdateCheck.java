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

public class UpdateCheck extends JFrame implements ActionListener {
    
    JButton b1,b2,b3;
    Choice c1;
    JTextField t1,t2,t3,t4,t5;
    
    UpdateCheck(){
        JLabel l1 = new JLabel("Check in Details");
        l1.setFont(new Font("Tahoma",Font.PLAIN,20));
        l1.setForeground(Color.BLUE);
        l1.setBounds(80,30,200,30);
        add(l1);
        
        JLabel l2 = new JLabel("Customer -ID");
        l2.setForeground(Color.BLUE);
        l2.setBounds(30,80,100,20);
        add(l2);
        c1 = new Choice();
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while(rs.next()){
                c1.add(rs.getString("number"));
            }
        }catch(Exception e){}
        c1.setBounds(200,80,150,25);
        add(c1);
        
        
        JLabel l3 = new JLabel("Room Number");
        l3.setForeground(Color.BLUE);
        l3.setBounds(30,120,100,20);
        add(l3);
        
        t1=new JTextField();
        t1.setBounds(200,120,150,25);
        add(t1);
        
        JLabel l4 = new JLabel("Name");
        l4.setForeground(Color.BLUE);
        l4.setBounds(30,160,100,20);
        add(l4);
        
        t2=new JTextField();
        t2.setBounds(200,160,150,25);
        add(t2);
        
        JLabel l5 = new JLabel("Checked-in");
        l5.setForeground(Color.BLUE);
        l5.setBounds(30,200,100,20);
        add(l5);
        
        t3=new JTextField();
        t3.setBounds(200,200,150,20);
        add(t3);
        
        JLabel l6 = new JLabel("Amount Paid");
        l6.setForeground(Color.BLUE);
        l6.setBounds(30,240,100,20);
        add(l6);
        
        t4=new JTextField();
        t4.setBounds(200,240,150,20);
        add(t4);
        
        JLabel l7 = new JLabel("Pending Amount");
        l7.setForeground(Color.BLUE);
        l7.setBounds(30,280,100,20);
        add(l7);
        
        
        t5=new JTextField();
        t5.setBounds(200,280,150,20);
        add(t5);
        
         b1 = new JButton("Check");
        b1.setBounds(30,340,100,30);
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Update");
        b2.setBounds(150,340,100,30);
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        b2.addActionListener(this);
        add(b2);
        
       
        b3 = new JButton("Back");
        b3.setBounds(270,340,100,30);
        b3.setForeground(Color.WHITE);
        b3.setBackground(Color.BLACK);
        b3.addActionListener(this);
        add(b3);
        
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/managment/system/icons/nine.jpg"));
    JLabel l10 = new JLabel(i1);
    l10.setBounds(400,50,500,300);
    add(l10);
        
         getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
        setBounds(350,200,980,500);
        setVisible(true);
    }
    
     public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==b1){
        
     try{
         String room = null;
         String deposit = null;
         int amountPaid = 0;
         String price = null;
            
            conn c = new conn();
            String id =c1.getSelectedItem();
             ResultSet rs = c.s.executeQuery("Select * from customer where number = '"+id+"'");
             //JOptionPane.showMessageDialog(null, "New Customer Added");
             while(rs.next()){
                 t1.setText(rs.getString("room_number"));
                 t2.setText(rs.getString("name"));
                 t3.setText(rs.getString("status"));
                 t4.setText(rs.getString("deposit"));
                 room = rs.getString("room_number");
                 deposit = rs.getString("deposit");
             }
             
             ResultSet rs2 = c.s.executeQuery("Select * from room where room_number = '"+room+"'");
             while(rs2.next()){
                 
                 price = rs2.getString("price");
                 amountPaid = Integer.parseInt(price) - Integer.parseInt(deposit);
                 t5.setText(Integer.toString(amountPaid));
                 //t3.setText(rs2.getString(""));
             }
             
         }catch(Exception e){
             System.out.println(e);
         }
        }else if(ae.getSource() == b2){
            try{
            
            conn c = new conn();
            String room = t1.getText();
            String available = t2.getText();
            String status = t4.getText();
            try{
                int sta = Integer.parseInt(t4.getText());
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Please enter a number");
            }
            String str = "update customer set deposit = '"+status+"' where room_number = '"+room+"'";
            c.s.executeUpdate(str);
             JOptionPane.showMessageDialog(null, "Updated Successfully");
             new Reception().setVisible(true);
             this.setVisible(false);
             
         }catch(Exception e){
             System.out.println(e);
         }

        }else if(ae.getSource() == b3){
                    new Reception().setVisible(true);
          this.setVisible(false);  
        }
        
        
    }
    public static void main(String[] args){
        new UpdateCheck().setVisible(true);
    }
}
    