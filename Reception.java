
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Reception extends JFrame implements ActionListener{
    JButton newcustmer,department,rooms,allEmployee,custmerInfo,managerInfo,searchRooms,update,roomUpdate,pickup,checkout,logout;
    Reception(){
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        newcustmer = new JButton("New Custmer Form");
        newcustmer.setBounds(10, 30, 200, 30);
        newcustmer.setBackground(Color.black);
        newcustmer.setForeground(Color.white);
        newcustmer.addActionListener(this);
        add(newcustmer);
        
        rooms = new JButton("Rooms");
        rooms.setBounds(10, 70, 200, 30);
        rooms.setBackground(Color.black);
        rooms.setForeground(Color.white);
        rooms.addActionListener(this);
        add(rooms);
        
        department = new JButton("Department");
        department.setBounds(10, 110, 200, 30);
        department.setBackground(Color.black);
        department.setForeground(Color.white);
        department.addActionListener(this);
        add(department);
        
        allEmployee = new JButton("All Employee");
        allEmployee.setBounds(10, 150, 200, 30);
        allEmployee.setBackground(Color.black);
        allEmployee.setForeground(Color.white);
        allEmployee.addActionListener(this);
        add(allEmployee);
        
        custmerInfo = new JButton("Custmer Information");
        custmerInfo.setBounds(10, 190, 200, 30);
        custmerInfo.setBackground(Color.black);
        custmerInfo.setForeground(Color.white);
        custmerInfo.addActionListener(this);
        add(custmerInfo);
        
        managerInfo = new JButton("Maneger Information");
        managerInfo.setBounds(10, 230, 200, 30);
        managerInfo.setBackground(Color.black);
        managerInfo.setForeground(Color.white);
        managerInfo.addActionListener(this);
        add(managerInfo);
        
        checkout = new JButton("Check Out");
        checkout.setBounds(10, 270, 200, 30);
        checkout.setBackground(Color.black);
        checkout.setForeground(Color.white);
        checkout.addActionListener(this);
        add(checkout);
        
        update = new JButton("Update Statuse");
        update.setBounds(10, 310, 200, 30);
        update.setBackground(Color.black);
        update.setForeground(Color.white);
        update.addActionListener(this);
        add(update);
        
        roomUpdate = new JButton("Update Rooms Statuse");
        roomUpdate.setBounds(10, 350, 200, 30);
        roomUpdate.setBackground(Color.black);
        roomUpdate.setForeground(Color.white);
        roomUpdate.addActionListener(this);
        add(roomUpdate);
        
        pickup = new JButton("Pickup Service");
        pickup.setBounds(10, 390, 200, 30);
        pickup.setBackground(Color.black);
        pickup.setForeground(Color.white);
        pickup.addActionListener(this);
        add(pickup);
        
        searchRooms = new JButton("Search Rooms");
        searchRooms.setBounds(10, 430, 200, 30);
        searchRooms.setBackground(Color.black);
        searchRooms.setForeground(Color.white);
        searchRooms.addActionListener(this);
        add(searchRooms);
        
        logout = new JButton("Log Out");
        logout.setBounds(10, 470, 200, 30);
        logout.setBackground(Color.black);
        logout.setForeground(Color.white);
        logout.addActionListener(this);
        add(logout);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(250, 30, 500, 470);
        add(image);
        
        
        setBounds(350, 200, 800, 570);
        setVisible(true);
           }
         
        public void actionPerformed(ActionEvent ae){
            if(ae.getSource() == newcustmer){
                setVisible(false);
                new AddCustemer();
                
            }else if(ae.getSource() == rooms){
                setVisible(false);
                new Room();
                
            }else if(ae.getSource() == department){
                setVisible(false);
                new Department();
                
            }else if(ae.getSource() == allEmployee){
                setVisible(false);
                 new EmployeeInfo();
            }
            else if(ae.getSource() == managerInfo){
                setVisible(false);
                 new ManagerInfo();
                 
            }else if(ae.getSource() == custmerInfo){
                setVisible(false);
                 new CustmerInfo();
            }else if(ae.getSource() == searchRooms){
                setVisible(false);
                 new SearchRoom();
                 
            }else if(ae.getSource() == update){
                setVisible(false);
                 new UpdateCheck();
                 
            }else if(ae.getSource() == roomUpdate){
                setVisible(false);
                 new UpdateRoom();
                 
            }else if(ae.getSource() == pickup){
                setVisible(false);
                 new Pickup();
                 
            }else if(ae.getSource() == checkout){
                setVisible(false);
                 new CheckOut();
            }else if(ae.getSource() == logout){
                setVisible(false);
                 System.exit(0);
            }
            
            

        }
    public static void main(String[] str){
      new Reception();
    }
}
