
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class SearchRoom extends JFrame  implements ActionListener{
    JButton back,submite;
    JTable table;
    JComboBox BedTypesOption;
    JCheckBox availabel;
    SearchRoom(){
    
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        
        JLabel Heading = new JLabel("Search for Room ");
        Heading.setBounds(400, 30, 200, 30);
        Heading.setFont(new Font("Tahoma", Font.BOLD, 18));
        add( Heading);
        
       JLabel BedTypes = new JLabel("Bad Types");
       BedTypes.setBounds(50, 100, 100, 20);
       BedTypes.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(BedTypes);
       
         String TypesOption[] = {"Single Bed", "Double Bed"};
        BedTypesOption = new JComboBox(TypesOption);
        BedTypesOption.setBounds(150, 100, 150, 22);
        BedTypesOption.setBackground(Color.white);
        add(BedTypesOption);
        
        availabel = new JCheckBox("Only Display Available");
        availabel.setBounds(650, 100, 150, 25);
        availabel.setBackground(Color.white);
        add(availabel);
        
        JLabel c1 = new JLabel("Room Number");
        c1.setBounds(10, 160, 100, 20);
        add(c1);
        
         JLabel c2 = new JLabel("Availability");
        c2.setBounds(210, 160, 100, 20);
        add(c2);
        
         JLabel c3 = new JLabel("Cleane Status");
        c3.setBounds(410, 160, 100, 20);
        add(c3);
        
         JLabel c4 = new JLabel("Bade Types");
        c4.setBounds(610, 160, 100, 20);
        add(c4);
        
         JLabel c5 = new JLabel("Price");
        c5.setBounds(810, 160, 100, 20);
        add(c5);
        
        table = new JTable();
        table.setBounds(0, 200, 1000, 300);
        add(table);
        try{
            Conn c = new Conn();
            
            ResultSet rs = c.s.executeQuery("select * from room");
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
                    
                    String query1 = "select * from room where BedTypes = '"+BedTypesOption.getSelectedItem()+"'";
                    String query2 = "select * from room where RoomAvailable = 'Available' and BedTypes = '"+BedTypesOption.getSelectedItem()+"'";
                    
                    Conn conn = new Conn();
                    ResultSet rs;
                    
                    if(availabel.isSelected()){
                        rs = conn.s.executeQuery(query2);
                    }else {
                        rs = conn.s.executeQuery(query1);
                    }
                    
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
        new SearchRoom();
 }   
}
