
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Room extends JFrame  implements ActionListener{
    JButton back;
    JTable table;
    Room(){
    
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500, 0, 600, 600);
        add(image);
        
        JLabel c1 = new JLabel("Room Number");
        c1.setBounds(8, 10, 100, 20);
        add(c1);
        
         JLabel c2 = new JLabel("Availability");
        c2.setBounds(110, 10, 100, 20);
        add(c2);
        
         JLabel c3 = new JLabel("Cleane Status");
        c3.setBounds(210, 10, 100, 20);
        add(c3);
        
         JLabel c4 = new JLabel("Bade Types");
        c4.setBounds(310, 10, 100, 20);
        add(c4);
        
         JLabel c5 = new JLabel("Price");
        c5.setBounds(410, 10, 100, 20);
        add(c5);
        
        table = new JTable();
        table.setBounds(0, 40, 500, 400);
        add(table);
        try{
            Conn c = new Conn();
            
            ResultSet rs = c.s.executeQuery("select * from room");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
            e.printStackTrace();
        }    
        
        back = new JButton("Back");
        back.setBounds(200, 500, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
    
        setBounds(300, 200, 1050, 6520);
        setVisible(true);                
    }
    
        public void actionPerformed(ActionEvent ae){
            setVisible(false);
            new Reception();
        }

   
    public static void main(String[] arg){
        new Room();
 }   
}
