
package hotel.managment.system;

import java.awt.*;
import java.awt.Font;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;
import java.text.DateFormat;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.Calendar;  
import java.time.LocalDate;

public class AddCustomer extends JFrame implements ActionListener {
    Connection conn = null;
    JTextField t1,t2,t3,t4,t5;
    JButton b1,b2,b3;
    JComboBox c1;
    Choice c2;
    JRadioButton r1,r2;
    //String m = "";
    
    
    AddCustomer(){
        
        JLabel l1 = new JLabel("NEW CUSTOMER FORM");
        l1.setBounds(100,20,300,30);
        l1.setForeground(Color.BLUE);
        //l1.setFont(new Font("Tahoma", Font.PLAIN,20));
        add(l1);
        
        JLabel l2 = new JLabel("ID");
        l2.setBounds(35,80,100,20);
        l2.setForeground(Color.BLUE);
        //l2.setFont(new Font("Tahoma", Font.PLAIN,20));
        add(l2);
        
        c1 = new JComboBox(new String[]{"Passport","Voter_id Card","Driving license","Aadhar Card"});
        c1.setBounds(200,80,120,25);
        add(c1);
        
        JLabel l3 = new JLabel("NUMBER");
        l3.setBounds(35,120,100,30);
        l3.setForeground(Color.BLUE);
        //l3.setFont(new Font("Tahoma", Font.PLAIN,20));
        add(l3);
        
        t1 = new JTextField();
        t1.setBounds(200,120,150,25);
        add(t1);
        
        JLabel l4 = new JLabel("NAME");
        l4.setBounds(35,160,100,30);
        l4.setForeground(Color.BLUE);
        //l4.setFont(new Font("Tahoma", Font.PLAIN,20));
        add(l4);
        
        t2 = new JTextField();
        t2.setBounds(200,160,150,25);
        add(t2);
        
        JLabel l5 = new JLabel("GENDER");
        l5.setBounds(35,200,100,30);
        l5.setForeground(Color.BLUE);
        //l5.setFont(new Font("Tahoma", Font.PLAIN,20));
        add(l5);
        
        r1 = new JRadioButton("Male");
        r1.setBounds(200,200,60,25);
        add(r1);
        
        
        r2 = new JRadioButton("Female");
        r2.setBounds(270,200,80,25);
        add(r2);
        
        JLabel l6 = new JLabel("COUNTRY");
        l6.setBounds(35,240,100,30);
        l6.setForeground(Color.BLUE);
        //l6.setFont(new Font("Tahoma", Font.PLAIN,20));
        add(l6);
        
        t3 = new JTextField();
        t3.setBounds(200,240,150,25);
        add(t3);
        
        JLabel l7 = new JLabel("Allocated Room Number");
        l7.setBounds(35,280,150,30);
        l7.setForeground(Color.BLUE);
        //l7.setFont(new Font("Tahoma", Font.PLAIN,20));
        add(l7);
        
        c2 = new Choice();
        try{
            conn c = new conn();
            String str = "select * from room where availability = 'Available'";
            ResultSet rs = c.s.executeQuery(str);
            while(rs.next()){
                c2.add(rs.getString("room_number"));
            }
        }catch(Exception e){}
        c2.setBounds(200,280,150,25);
        add(c2);
        
       
        
        
        JLabel l8 = new JLabel("CHECKED IN");
        l8.setBounds(35,320,100,20);
        l8.setForeground(Color.BLUE);
        //l8.setFont(new Font("Tahoma", Font.PLAIN,20));
        add(l8);
        
        t4 = new JTextField();
        t4.setBounds(200,320,130,25);
        add(t4);
        
        JLabel l9 = new JLabel("DEPOSIT");
        l9.setBounds(35,360,100,20);
        l9.setForeground(Color.BLUE);
        //l9.setFont(new Font("Tahoma", Font.PLAIN,20));
        add(l9);
        
        t5 = new JTextField();
        t5.setBounds(200,360,150,25);
        add(t5);
        
        b1 = new JButton("Add Customer");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(50,410,120,25);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(200,410,120,25);
        b2.addActionListener(this);
        add(b2);
        
        
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/managment/system/icons/fifth.jpg"));
    Image i2 = i1.getImage().getScaledInstance(300,400, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel l10 = new JLabel(i3);
    l10.setBounds(400,50,300,400);
    add(l10);
    
    ImageIcon i5 = new ImageIcon(ClassLoader.getSystemResource("hotel/managment/system/icons/tick.png"));
   Image i6 = i5.getImage().getScaledInstance(20,20, Image.SCALE_DEFAULT);
    ImageIcon i7 = new ImageIcon(i6);
    b3 = new JButton(i7);
    b3.setBounds(330,320,20,20);
    b3.addActionListener(this);
    add(b3);
    
        getContentPane().setBackground(Color.WHITE);
        
        
        
        
        setLayout(null);
        setBounds(550,200,800,550);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==b1){
            try{
                int as = Integer.parseInt(t5.getText());
         

        String id = (String) c1.getSelectedItem();
        String number = t1.getText();
        String name = t2.getText();
        String gender = null;
        if(r1.isSelected()){
            gender = "Male";
        }else if(r2.isSelected()){
            gender = "Female";
        }
        
        String country = t3.getText();
        String room = c2.getSelectedItem();
        String status = t4.getText();
        String deposit = t5.getText();
        
        String str = "insert into customer values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+status+"','"+deposit+"')";
        String str2 = "update room set availability = 'Occupied' where room_number ='"+room+"'";
        try{
            
            conn c = new conn();
             c.s.executeUpdate(str);
             c.s.executeUpdate(str2);
             JOptionPane.showMessageDialog(null, "New Customer Added");
             new Reception().setVisible(true);
             this.setVisible(false);
         }catch(Exception e){
             System.out.println(e);
         }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Deposit is not in Proper Format");
        }
        }else if(ae.getSource() == b2){
          new Reception().setVisible(true);
          this.setVisible(false);
        }else if(ae.getSource() == b3){
            
            try{
                
                 Date date = new Date();  
                  SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");  
    String strDate = formatter.format(date);  
                 t4.setText(strDate);
             
            }catch(Exception e){}
        }
        
        
    }
    
    
    public static void main(String[] args){  
        new AddCustomer().setVisible(true);
    }
}
