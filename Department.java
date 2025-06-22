
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Department extends JFrame  implements ActionListener{
    JButton back;
    JTable table;
    Department(){
    
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        
       
        
        JLabel c1 = new JLabel("Department");
        c1.setBounds(150, 10, 100, 20);
        add(c1);
        
         JLabel c2 = new JLabel("Budget");
        c2.setBounds(400, 10, 100, 20);
        add(c2);
        
        
        table = new JTable();
        table.setBounds(0, 50, 700, 350);
        add(table);
        try{
            Conn c = new Conn();
            
            ResultSet rs = c.s.executeQuery("select * from department");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
            e.printStackTrace();
        }    
        
        back = new JButton("Back");
        back.setBounds(280, 400, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
    
        setBounds(400, 200, 700, 480);
        setVisible(true);                
    }
    
        public void actionPerformed(ActionEvent ae){
            setVisible(false);
            new Reception();
        }

   
    public static void main(String[] arg){
        new Department();
 }   
}
