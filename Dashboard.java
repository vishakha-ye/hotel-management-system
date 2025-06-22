
package hotel.management.system;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener{
    
    Dashboard(){
        
       setBounds(0, 0, 1550, 1000);
       setLayout(null);
      
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel imageLabel = new JLabel(i3);
        imageLabel.setBounds(0, 0, 1550, 1000);
        add(imageLabel);
        
         JLabel text = new JLabel("The Taj Group Welcome You");
        text.setBounds(400, 80, 1000, 50);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("serif", Font.PLAIN, 46));
        imageLabel.add(text);
        
        JMenuBar mb = new JMenuBar();
        mb.setBounds(0, 0, 1550, 30);
        imageLabel.add(mb);
        
        JMenu hotel = new JMenu("HOTEL MANAGEMENT");
        hotel.setForeground(Color.red);
        mb.add(hotel);
        
        JMenuItem reception = new JMenuItem("RECEPTION");
        reception.addActionListener(this);
        hotel.add(reception);
        
        JMenu admin = new JMenu("ADMIN");
        admin.setForeground(Color.BLUE);
        mb.add(admin);
        
        JMenuItem ae = new JMenuItem("ADD EMPLOYEE");
        ae.addActionListener(this);
        admin.add(ae);
        
        JMenuItem ar = new JMenuItem("ADD ROOM");
        ar.addActionListener(this);
        admin.add(ar);
        
        JMenuItem ad = new JMenuItem("ADD DRIVER");
        ad.addActionListener(this);
        admin.add(ad);
               
         setVisible(true);      
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("ADD EMPLOYEE")){
            new AddEmployee();
            
        }else if(ae.getActionCommand().equals("ADD ROOM")){
            new AddRoom();
          
        }else if(ae.getActionCommand().equals("ADD DRIVER")){
            new AddDriver();
           
        }else if(ae.getActionCommand().equals("RECEPTION")){
            new Reception();
        }
    }
    
    public static void main(String[] avg){
        
        new Dashboard();
    }
        
}
