
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Date;
import java.awt.event.*;

public class AddCustemer extends JFrame implements ActionListener{
    
    JComboBox cbid;
    JTextField tfnumber,tfname,tfcontry,tfdeposite;
    JRadioButton rbmale,rbfemale;
    Choice callocated;
    JLabel check;
    JButton Add,back;
   
            
    AddCustemer(){
       
    getContentPane().setBackground(Color.white);
    setLayout(null);
    
    JLabel Heading = new JLabel("NEW CUSTEMER FORM");
    Heading.setBounds(100, 20, 300, 30);
    Heading.setFont(new Font("Tahoma", Font.BOLD, 18));
    add( Heading);
    
    JLabel id = new JLabel("ID");
    id.setBounds(35, 80, 100, 20);
    id.setFont(new Font("Tahoma", Font.PLAIN, 18));
    add( id);
    
    String options[] = {"Adhar Card", "Passport","Pane Card","Votor ID", "Driving Licens"};
    cbid = new JComboBox(options);
    cbid.setBounds(200, 80, 150, 25);
    cbid.setBackground(Color.white);
    add(cbid);
    
    JLabel number = new JLabel("Number");
    number.setBounds(35, 120, 100, 20);
    number.setFont(new Font("Tahoma", Font.PLAIN, 18));
    add( number);
    
    tfnumber = new JTextField();
    tfnumber.setBounds(200, 120, 150, 25);
    add(tfnumber);
    
    JLabel name = new JLabel("Name");
    name.setBounds(35, 160, 100, 20);
    name.setFont(new Font("Tahoma", Font.PLAIN, 18));
    add( name);
    
    tfname = new JTextField();
    tfname.setBounds(200, 160, 150, 25);
    add(tfname);
    
    JLabel gender = new JLabel("Gender");
    gender.setBounds(35, 200, 100, 20);
    gender.setFont(new Font("Tahora", Font.PLAIN,17));
    add(gender);
        
        rbmale = new JRadioButton("Male");
        rbmale.setBounds(200, 195, 70, 30);
        rbmale.setFont(new Font("Tahora", Font.PLAIN,11));
        rbmale.setBackground(Color.white);
        add(rbmale);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);
        
         rbfemale =new JRadioButton("female");
        rbfemale.setBounds(280, 195, 70, 30);       
        rbfemale.setFont(new Font("Tahora", Font.PLAIN,11));
        rbfemale.setBackground(Color.white);
        add(rbfemale);
    
    JLabel contry = new JLabel("Country");
    contry.setBounds(35, 240, 100, 20);
    contry.setFont(new Font("Tahoma", Font.PLAIN, 18));
    add( contry);
    
    tfcontry = new JTextField();
    tfcontry.setBounds(200, 240, 150, 25);
    add(tfcontry);
    
    JLabel alocated = new JLabel("Room Number");
    alocated.setBounds(35, 280, 150, 20);
    alocated.setFont(new Font("Tahoma", Font.PLAIN, 18));
    add( alocated);
    
    callocated = new Choice();
    
    try{
        
        Conn conn = new Conn();
        String query = "select * from room where RoomAvailable = 'Available'";
        ResultSet rs = conn.s.executeQuery(query);
        while(rs.next()){
        callocated.add(rs.getString("RoomNO"));
    }  
    }catch(Exception e){
       e.printStackTrace();
    }
    callocated.setBounds(200, 280, 150, 25);
    add(callocated);
    
    JLabel checkintime = new JLabel("Check In Time");
    checkintime.setBounds(35, 320, 150, 25);
    checkintime.setFont(new Font("Tahoma", Font.PLAIN, 18));
    add( checkintime);
    
    Date date = new Date();
    
    check = new JLabel(" " + date);
    check.setBounds(200, 320, 150, 25);
    check.setFont(new Font("Tahoma", Font.PLAIN, 15));
    add( check);
    
    
    JLabel deposite = new JLabel("Deposite");
    deposite.setBounds(35, 360, 100, 20);
    deposite.setFont(new Font("Tahoma", Font.PLAIN, 18));
    add( deposite);
    
    tfdeposite = new JTextField();
    tfdeposite.setBounds(200, 360, 150, 25);
    add(tfdeposite);

    Add = new JButton("ADD");
    Add.setBackground(Color.black);
    Add.setForeground(Color.white);
    Add.setBounds(50, 410, 120, 30);
    Add.addActionListener(this);
    add(Add);
        
    back = new JButton("Back");
    back.setBounds(200, 410, 120, 30);
    back.setBackground(Color.BLACK);
    back.setForeground(Color.WHITE);
    back.addActionListener(this);
    add(back);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 50, 300, 400);
        add(image);
        
    setBounds(350, 200, 800, 550);
    setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == Add){
            
            String id = (String) cbid.getSelectedItem();
            String name = tfname.getText();
            String checkintime = check.getText();
            String allocated = callocated.getSelectedItem();
            String contry = tfcontry.getText();
            String number = tfnumber.getText();
            String deposite = tfdeposite.getText();
            String gender = null;
                if(rbmale.isSelected()){
                     gender = "male";
                     }else if(rbfemale.isSelected()){
                     gender = "female";
                         }
                try{
                    
                 String query = "Insert  into custemer value('"+id+"' ,'"+number+"' ,'"+name+"' ,'"+gender+"' ,'"+contry+"','"+allocated+"','"+checkintime+"','"+deposite+"')";
                 String query2 = "update  room set RoomAvailable = 'Occuped' where RoomNO = '"+allocated+"'";
                 
                 Conn conn = new Conn();
                 
                 conn.s.executeUpdate(query);
                 conn.s.executeUpdate(query2);
                 
                JOptionPane.showMessageDialog(null, "New Custemer added succesfull");
                setVisible(false);
                new Reception();
                }catch(Exception e){
                    e.printStackTrace();
                }
            
        }else if(ae.getSource() ==back){
            setVisible(false);
                new Reception();
            
        }
    }
public static void main(String[] str){
    new AddCustemer();
}    
}

