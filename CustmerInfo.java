package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class CustmerInfo extends JFrame  implements ActionListener{
    JButton back;
    JTable table;
    CustmerInfo(){
    
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
      
        
        JLabel c1 = new JLabel("Documents");
        c1.setBounds(8, 10, 100, 20);
        add(c1);
        
         JLabel c2 = new JLabel("Phone Number");
        c2.setBounds(130, 10, 100, 20);
        add(c2);
        
         JLabel c3 = new JLabel("Name ");
        c3.setBounds(250, 10, 100, 20);
        add(c3);
        
         JLabel c0 = new JLabel("Gender ");
        c0.setBounds(380, 10, 100, 20);
        add(c0);
        
         JLabel c4 = new JLabel("Contry ");
        c4.setBounds(500, 10, 100, 20);
        add(c4);
        
         JLabel c5 = new JLabel("Room Number");
        c5.setBounds(630, 10, 100, 20);
        add(c5);
        
        JLabel c6 = new JLabel("Chech In Time ");
        c6.setBounds(755, 10, 100, 20);
        add(c6);
        
         JLabel c7 = new JLabel("Deposite");
        c7.setBounds(880, 10, 100, 20);
        add(c7);
        
        table = new JTable();
        table.setBounds(0, 40, 1000, 400);
        add(table);
        try{
            Conn c = new Conn();
            
            ResultSet rs = c.s.executeQuery("select * from custemer");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
            e.printStackTrace();
        }    
        
        back = new JButton("Back");
        back.setBounds(420, 500, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
    
        setBounds(300, 200, 1000, 6520);
        setVisible(true);                
    }
    
        public void actionPerformed(ActionEvent ae){
            setVisible(false);
            new Reception();
        }

   
    public static void main(String[] arg){
        new CustmerInfo();
 }   
}
