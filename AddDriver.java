
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddDriver  extends JFrame implements ActionListener{
    
     JTextField tfn,tfa,tfcarcompny,tfcarmodel,tflocation;
      JButton AddDriver,cancel;
       JRadioButton rbm,rbf;

    JComboBox cbDriverAvailable;
    AddDriver(){       
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel Heading = new JLabel("Add Driver");
        Heading.setBounds(150, 20, 200, 30);
         Heading.setFont(new Font("Tahoma", Font.BOLD, 18));
        add( Heading);
        
       JLabel ln = new JLabel("Name");
        ln.setBounds(60, 80, 120, 30);
        ln.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(ln);
        
        tfn = new JTextField();
        tfn.setBounds(200, 80, 150, 30);
        add(tfn);
        
        JLabel la = new JLabel("Age");
        la.setBounds(60, 130, 120, 30);
        la.setFont(new Font("Tahoma", Font.PLAIN,17));
        add(la);
        
        tfa = new JTextField();
        tfa.setBounds(200, 130, 150, 30);
        add(tfa);
        
        JLabel lg = new JLabel("Gender");
        lg.setBounds(60,180,120,30);
        lg.setFont(new Font("Tahora", Font.PLAIN,17));
        add(lg);
        
         rbm = new JRadioButton("Male");
        rbm.setBounds(200, 180, 70, 30);
        rbm.setFont(new Font("Tahora", Font.PLAIN,11));
        rbm.setBackground(Color.white);
        add(rbm);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbm);
        bg.add(rbf);
        
         rbf =new JRadioButton("female");
        rbf.setBounds(280, 180, 70, 30);       
        rbf.setFont(new Font("Tahora", Font.PLAIN,11));
        rbf.setBackground(Color.white);
        add(rbf);
        
         JLabel DriverAvailable = new JLabel("Driver Available");
       DriverAvailable.setBounds(60, 230, 120, 30);
       DriverAvailable.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(DriverAvailable);
        
        String availableOption[] = {"Available", "Occupied"};
        cbDriverAvailable = new JComboBox(availableOption);
        cbDriverAvailable.setBounds(200, 230, 150, 30);
        cbDriverAvailable.setBackground(Color.white);
        add(cbDriverAvailable);
        
       
        
        JLabel carcompny = new JLabel("Car Compny");
       carcompny.setBounds(60, 280, 120, 20);
       carcompny.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add( carcompny);
        
        tfcarcompny = new JTextField();
        tfcarcompny.setBounds(200, 280, 150, 30);
        add(tfcarcompny);
        
        JLabel carmodel = new JLabel("Car Model");
       carmodel.setBounds(60, 330, 120, 30);
       carmodel.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add( carmodel);
        
        tfcarmodel = new JTextField();
        tfcarmodel.setBounds(200, 330, 150, 30);
        add(tfcarmodel);
        
        JLabel location = new JLabel("Location");
       location.setBounds(60, 380, 120, 30);
       location.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add( location);
        
        tflocation = new JTextField();
        tflocation.setBounds(200, 380, 150, 30);
        add(tflocation);
       
        AddDriver = new JButton("Add Driver");
        AddDriver.setBackground(Color.black);
        AddDriver.setForeground(Color.white);
        AddDriver.setBounds(60, 450, 130, 30);
        AddDriver.addActionListener(this);
        add(AddDriver);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(220, 450, 130, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 100, 500, 300);
        add(image);
        
        setBounds(300, 200, 940, 570);
        setVisible(true);
          
    }
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == AddDriver){
            
            String name = tfn.getText();
            String age = tfa.getText();
            String DriverAvailable = (String) cbDriverAvailable.getSelectedItem();
            String carcompny = tfcarcompny.getText();
            String carmodel = tfcarmodel.getText();
            String location = tflocation.getText();
            String gender = null;
        
                if(rbm.isSelected()){
                     gender = "male";
                     }else if(rbf.isSelected()){
                     gender = "female";
                         }
            
            try{
                
                Conn conn = new Conn();
                
                String str = "Insert  into driver value('"+name+"' ,'"+age+"' ,'"+gender+"' ,'"+DriverAvailable+"' ,'"+carcompny+"','"+carmodel+"' ,'"+location+"')";
                
            conn.s.executeUpdate(str);
            
            JOptionPane.showMessageDialog(null, "Driver added succesfull");
            
            setVisible(false);
            
            }catch(Exception e){
                        e.printStackTrace();
                        
               }                   
    }else{
            setVisible(false);
            }
        
    }
    public static void main(String[] avg){
        new AddDriver();
    }
}
