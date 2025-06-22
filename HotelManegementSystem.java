
package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;

public class HotelManegementSystem extends JFrame implements ActionListener {

    JButton next; 

    HotelManegementSystem() {
        
        setSize(1366, 565);
        setLocation(100, 100);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1342, 500);
        add(image);
        
        

        JLabel text = new JLabel("Hotel Management System");
        text.setBounds(20, 430, 1000, 90);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("serif", Font.PLAIN, 50));
        image.add(text);

        next = new JButton("Next");
        next.setBounds(1150, 450, 150, 50);
        next.setBackground(Color.WHITE);
        next.setForeground(Color.MAGENTA);
        next.setFont(new Font("serif", Font.PLAIN, 24));
        next.addActionListener(this); 
        image.add(next);

        setVisible(true);

     
        new Thread(() -> {
            while (true) {
                text.setVisible(false);
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                text.setVisible(true);
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

   
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            setVisible(false); 
            new Login();
        }
    }

    public static void main(String[] args) {
        new HotelManegementSystem();
    }
}
