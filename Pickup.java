
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Pickup extends JFrame  implements ActionListener{
    JButton back,submite;
    JTable table;
    Choice  typesofcar;
    JCheckBox availabel;
    Pickup(){
    
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        
        JLabel Heading = new JLabel("Pickup Service  ");
        Heading.setBounds(400, 30, 200, 30);
        Heading.setFont(new Font("Tahoma", Font.BOLD, 18));
        add( Heading);
        
       JLabel BedTypes = new JLabel("Car Types");
       BedTypes.setBounds(50, 100, 100, 20);
       BedTypes.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(BedTypes);
        
        
        typesofcar = new Choice();
        typesofcar.setBounds(150, 100, 200, 25);
        add(typesofcar);
        
         try{
            Conn c = new Conn();
            
            ResultSet rs = c.s.executeQuery("select * from driver");
            while(rs.next()){
             typesofcar.add(rs.getString("carmodel"));
                
            } 
        }catch(Exception e){
            e.printStackTrace();
        }    
        
        
        
        
        JLabel c1 = new JLabel("Driver Name");
        c1.setBounds(10, 160, 100, 20);
        add(c1);
        
         JLabel c2 = new JLabel("Age");
        c2.setBounds(150, 160, 100, 20);
        add(c2);
        
         JLabel c3 = new JLabel("Gender");
        c3.setBounds(290, 160, 100, 20);
        add(c3);
        
         JLabel c4 = new JLabel("Availability");
        c4.setBounds(433, 160, 100, 20);
        add(c4);
        
         JLabel c5 = new JLabel("Car Company");
        c5.setBounds(575, 160, 100, 20);
        add(c5);
        
         JLabel c0 = new JLabel("Car Model");
        c0.setBounds(720, 160, 100, 20);
        add(c0);
        
         JLabel c6 = new JLabel("Location");
        c6.setBounds(860, 160, 100, 20);
        add(c6);
        
        table = new JTable();
        table.setBounds(0, 200, 1000, 300);
        add(table);
        try{
            Conn c = new Conn();
            
            ResultSet rs = c.s.executeQuery("select * from driver");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
            e.printStackTrace();
        }    
        
        submite = new JButton("Submite");
        submite.setBounds(300, 520, 120, 30);
        submite.setBackground(Color.BLACK);
        submite.setForeground(Color.WHITE);
        submite.addActionListener(this);
        add(submite);
        
        back = new JButton("Back");
        back.setBounds(500, 520, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
    
        setBounds(300, 200, 1000, 600);
        setVisible(true);                
    }
    
        public void actionPerformed(ActionEvent ae){
            if(ae.getSource()  == submite){
                
                try{
                    
                    String query = "select * from driver where carmodel = '"+typesofcar.getSelectedItem()+"'";
                    
                    Conn conn = new Conn();
                    ResultSet rs;
                   
                        rs = conn.s.executeQuery(query);
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                    
                }catch(Exception e){
                    e.printStackTrace();
                }
                
            }else{
            setVisible(false);
            new Reception();
        }
     }
   
    public static void main(String[] arg){
        new Pickup();
 }   
}
