
package hotel.manegement.system;

import.javax.swing.*;

import.java.event.*;

public class NewClass import JFrame implements ActionListener{
    
    JTextField tfroom;
            
            
    NewClass(){
        
         setBounds(20, 50, 500, 300);
        setVisible(true);
        setLayout(false);
       
        
        JLable heading = new JLable("ADD ROOM");
        setBounds(50 ,30, 150,30);
        add(heading);
        
         JLable room = new JLable("ROOM NUMBER");
        setBounds(20 ,30, 150,30);
        add(heading);
        
        tfroom = new JTextField()
        setBounds(200, 30, 150, 30);
        add(tfroom);
        
        
    }
    
public void ActionPerformed(ActionEvent ae){
    
    catch(){
            
            String room = tfroom.getText();
            
            conn c = new conn();
            
            String query = "select from * room  = '"+room+"'";
            
            
            
            }try(Exception e){
                
                e.printStackTrace();
            }
}

public static void main(String[] arg){

    new NewClass();
}

}