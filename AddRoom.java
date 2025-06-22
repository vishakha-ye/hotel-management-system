
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddRoom  extends JFrame implements ActionListener{
    
     JTextField tfRoomNO,tfprice;
      JButton AddRoom,cancel;
    JComboBox cbRoomAvailable,cbclean,BedTypesOption;
    AddRoom(){       
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel Heading = new JLabel("Add Room");
        Heading.setBounds(150, 20, 200, 20);
         Heading.setFont(new Font("Tahoma", Font.BOLD, 18));
        add( Heading);
        
        JLabel RoomNO = new JLabel("Room Number");
       RoomNO.setBounds(60, 80, 120, 20);
       RoomNO.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add( RoomNO);
        
         tfRoomNO = new JTextField();
        tfRoomNO.setBounds(200, 80, 150, 20);
        add(tfRoomNO);
        
         JLabel RoomAvailable = new JLabel("Room Available");
       RoomAvailable.setBounds(60, 130, 120, 20);
       RoomAvailable.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(RoomAvailable);
        
        String availableOption[] = {"Available", "Occupied"};
        cbRoomAvailable = new JComboBox(availableOption);
        cbRoomAvailable.setBounds(200, 130, 150, 20);
        cbRoomAvailable.setBackground(Color.white);
        add(cbRoomAvailable);
        
        JLabel Clean = new JLabel("Clean Status");
       Clean.setBounds(60, 180, 120, 20);
       Clean.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(Clean);
        
        String CleanOption[] = {"Cleaned", "Dirty"};
        cbclean = new JComboBox(CleanOption);
        cbclean.setBounds(200, 180, 150, 20);
        cbclean.setBackground(Color.white);
        add(cbclean);
        
        JLabel price = new JLabel("Price");
       price.setBounds(60, 230, 120, 20);
       price.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add( price);
        
        tfprice = new JTextField();
        tfprice.setBounds(200, 230, 150, 20);
        add(tfprice);
        
        JLabel BedTypes = new JLabel("Bed Types");
       BedTypes.setBounds(60, 280, 120, 20);
       BedTypes.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(BedTypes);
        
        String TypesOption[] = {"Single Bed", "Double Bed"};
        BedTypesOption = new JComboBox(TypesOption);
        BedTypesOption.setBounds(200, 280, 150, 20);
        BedTypesOption.setBackground(Color.white);
        add(BedTypesOption);
        
        AddRoom = new JButton("Add Room");
        AddRoom.setBackground(Color.black);
        AddRoom.setForeground(Color.white);
        AddRoom.setBounds(60, 350, 130, 30);
        AddRoom.addActionListener(this);
        add(AddRoom);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(220, 350, 130, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 30, 500, 300);
        add(image);
        
        setBounds(300, 200, 940, 470);
        setVisible(true);
          
    }
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == AddRoom){
            
            String RoomNO = tfRoomNO.getText();
            String RoomAvailable = (String) cbRoomAvailable.getSelectedItem();
            String Clean = (String) cbclean.getSelectedItem();
            String BedTypes = (String) BedTypesOption.getSelectedItem();
            String price = tfprice.getText();
            
            try{
                
                Conn conn = new Conn();
                
                String str = "Insert  into room value('"+RoomNO+"' ,'"+RoomAvailable+"' ,'"+Clean+"' ,'"+BedTypes+"' ,'"+price+"')";
                
            conn.s.executeUpdate(str);
            
            JOptionPane.showMessageDialog(null, "New Room added succesfull");
            
            setVisible(false);
            
            }catch(Exception e){
                        e.printStackTrace();
                        
               }                   
    }else{
            setVisible(false);
            }
        
    }
    public static void main(String[] avg){
        new AddRoom();
    }
}
