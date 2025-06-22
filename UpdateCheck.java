
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class UpdateCheck extends JFrame  implements ActionListener{
    
        JTextField tfroomno,tfname,tfcheck,tfamount,tfpandingamount;
        Choice custemer;
        JButton  checked,update,back;
        
    UpdateCheck(){
        

        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel Heading = new JLabel("Update Status ");
        Heading.setBounds(19, 20, 200, 30);
        Heading.setFont(new Font("Tahoma", Font.BOLD, 18));
        add( Heading);
        
        JLabel id = new JLabel("Custemer ID");
        id.setBounds(30, 80, 100, 20);
        add( id);
        
        custemer = new Choice();
        custemer.setBounds(200, 80, 150, 25);
        add(custemer);

    try{
        
        Conn c = new Conn();
        
        String query1 = "select * from custemer";
        
        ResultSet rs = c.s.executeQuery(query1);
        
        while(rs.next()){
        custemer.add(rs.getString("Number"));
    }  
    }catch(Exception e){
       e.printStackTrace();
    }
    
    JLabel roomnumber = new JLabel("Room Number ");
    roomnumber.setBounds(30, 120, 100, 20);
    add( roomnumber);
        
    tfroomno = new JTextField();
    tfroomno.setBounds(200, 120, 150, 25);
    add(tfroomno);
    
    JLabel name = new JLabel("Name ");
    name.setBounds(30, 160, 100, 20);
    add( name);
        
    tfname = new JTextField();
    tfname.setBounds(200, 160, 150, 25);
    add(tfname);
    
    JLabel check = new JLabel("Check In Time ");
    check.setBounds(30, 200, 100, 20);
    add( check);
        
    tfcheck = new JTextField();
    tfcheck.setBounds(200, 200, 150, 25);
    add(tfcheck);
    
    JLabel amount = new JLabel("Amount Paid");
    amount.setBounds(30, 240, 100, 20);
    add( amount);
        
    tfamount = new JTextField();
    tfamount.setBounds(200, 240, 150, 25);
    add(tfamount);
    
    JLabel pandingamount = new JLabel(" Panding Amount");
    pandingamount.setBounds(30, 280, 100, 20);
    add( pandingamount);
        
    tfpandingamount = new JTextField();
    tfpandingamount.setBounds(200, 280, 150, 25);
    add(tfpandingamount);
    
    checked = new JButton("Check");
    checked.setBounds(30, 380, 100, 30);
    checked.setBackground(Color.BLACK);
    checked.setForeground(Color.WHITE);
    checked.addActionListener(this);
    add(checked);
        
    update = new JButton("Update");
    update.setBounds(150, 380, 100, 30);
    update.setBackground(Color.BLACK);
    update.setForeground(Color.WHITE);
    update.addActionListener(this);
    add(update);
        
      back = new JButton("Back");
    back.setBounds(270, 380, 100, 30);
    back.setBackground(Color.BLACK);
    back.setForeground(Color.WHITE);
    back.addActionListener(this);
    add(back);
        
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
    JLabel image = new JLabel(i1);
    image.setBounds(400, 50, 500, 300);
    add(image);
                  
        setBounds(300, 200, 980, 500);
        setVisible(true);                                                           
    }
    
public void actionPerformed(ActionEvent ae){
    
    if(ae.getSource() == checked){
        
        String id = custemer.getSelectedItem();
        String query = "select * from custemer where Number ='"+id+"'";
        
        try{
            
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                
                tfroomno.setText(rs.getString("Room"));
                tfname.setText(rs.getString("Name"));
                tfcheck.setText(rs.getString("Check_In_Time"));
                tfamount.setText(rs.getString("Deposite"));
            }
            
            ResultSet rs2 = c.s.executeQuery("select * from room where RoomNO = '"+tfroomno.getText()+"'");
             while(rs2.next()){
               String price = rs2.getString("price");
               int amountPaid = Integer.parseInt(price) - Integer.parseInt(tfamount.getText());
               tfpandingamount.setText("" + amountPaid);
               
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }else if(ae.getSource() == update){
        
        String number = custemer.getSelectedItem();
        String roomnumber = tfroomno.getText();
        String name = tfname.getText();
        String check = tfcheck.getText();
        String amount = tfamount.getText();
        
        try{
            
            Conn c = new Conn();
            c.s.executeUpdate("update custemer set Room = '"+roomnumber+"', Name = '"+name+"', Check_In_Time = '"+check+"', Deposite = '"+amount+"' where Number = '"+number+"'");
            JOptionPane.showMessageDialog(null, "Data Updated Successfully");
            setVisible(false);
            new Reception();
            
        }catch(Exception e){
            e.printStackTrace();
            
        }
        
        
    }else{
         setVisible(false);
            new Reception();
        
    }
}    
    public static void main(String[] arg){
        
        new UpdateCheck();
    }
}
