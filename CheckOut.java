
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Date;
import java.awt.event.*;

public class CheckOut extends JFrame implements ActionListener{
    Choice custemer;
     JLabel jlroom,jlcheckintime,jlbcheckouttime;
     JButton  checked,back;
     
    CheckOut(){
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel Heading = new JLabel("CkeckOut ");
        Heading.setBounds(100, 20, 100, 30);
        Heading.setFont(new Font("Tahoma", Font.BOLD, 18));
        add( Heading);
        
        JLabel id = new JLabel("Custumer ID ");
        id.setBounds(30, 77, 100, 30);
        add( id);
        
        custemer = new Choice();
        custemer.setBounds(150, 80, 150, 25);
        add(custemer);

         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
        Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(310, 80, 20, 20);
        add(image);
                  
       JLabel room = new JLabel("Room Number ");
        room.setBounds(30, 130, 100, 30);
        add( room);
        
        jlroom = new JLabel();
        jlroom.setBounds(150, 130, 100, 30);
        add( jlroom);
        
        JLabel checkintime = new JLabel("Check In Time");
        checkintime.setBounds(30, 180, 100, 30);
        add( checkintime);
        
        jlcheckintime = new JLabel();
        jlcheckintime.setBounds(150, 180, 100, 30);
        add( jlcheckintime);
        
        JLabel checkouttime = new JLabel("Check Out Time");
        checkouttime.setBounds(30, 230, 100, 30);
        add( checkouttime);
        
        Date date = new Date();
        jlbcheckouttime = new JLabel("" + date);
        jlbcheckouttime.setBounds(150, 230, 150, 30);
        add( jlbcheckouttime);
        
          checked = new JButton("Check");
    checked.setBounds(30, 280, 120, 30);
    checked.setBackground(Color.BLACK);
    checked.setForeground(Color.WHITE);
    checked.addActionListener(this);
    add(checked);
          
      back = new JButton("Back");
    back.setBounds(170, 280, 120, 30);
    back.setBackground(Color.BLACK);
    back.setForeground(Color.WHITE);
    back.addActionListener(this);
    add(back);
    
    
    try{
        
        Conn c = new Conn();
        
        String query1 = "select * from custemer";
        
        ResultSet rs = c.s.executeQuery(query1);
        
        while(rs.next()){
        custemer.add(rs.getString("Number"));
        jlroom.setText(rs.getString("Room"));
        jlcheckintime.setText(rs.getString("Check_In_Time"));
          
    }  
    }catch(Exception e){
       e.printStackTrace();
    }
    
    ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
        Image i5 = i4.getImage().getScaledInstance(400, 250, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel imaged = new JLabel(i6);
        imaged.setBounds(350, 50, 400, 250);
        add(imaged);
         
        setBounds(300, 200, 800, 400);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == checked){
            
            String query1 = "delete from custemer where Number = '"+custemer.getSelectedItem()+"'";
            String query2 = "update room set RoomAvailable = 'Available' where RoomNO = '"+jlroom.getText()+"'";
            
            try{
                
                Conn c = new Conn();
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null, "Check Out Done");
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
        new CheckOut();
    }
}
