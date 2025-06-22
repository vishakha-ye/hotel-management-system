
package hotel.management.system;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;

public class AddEmployee extends JFrame implements ActionListener{
    
    JTextField tfn,tfa,tfs,tfp,tfaa,tfe;
    JRadioButton rbm,rbf;
    JButton sb;
    JComboBox cb;
    
    
    AddEmployee(){
    
        setLayout(null);
        
        JLabel ln = new JLabel("Name");
        ln.setBounds(60, 30, 150, 30);
        ln.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(ln);
        
        tfn = new JTextField();
        tfn.setBounds(200, 30, 120, 30);
        add(tfn);
        
        JLabel la = new JLabel("Age");
        la.setBounds(60, 80, 150, 30);
        la.setFont(new Font("Tahoma", Font.PLAIN,17));
        add(la);
        
        tfa = new JTextField();
        tfa.setBounds(200, 80, 150, 30);
        add(tfa);
        
        JLabel lg = new JLabel("Gender");
        lg.setBounds(60,130,150,30);
        lg.setFont(new Font("Tahora", Font.PLAIN,17));
        add(lg);
        
         rbm = new JRadioButton("Male");
        rbm.setBounds(200, 130, 70, 30);
        rbm.setFont(new Font("Tahora", Font.PLAIN,11));
        rbm.setBackground(Color.white);
        add(rbm);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbm);
        bg.add(rbf);
        
         rbf =new JRadioButton("female");
        rbf.setBounds(280, 130, 70, 30);       
        rbf.setFont(new Font("Tahora", Font.PLAIN,11));
        rbf.setBackground(Color.white);
        add(rbf);
        
        JLabel lj = new JLabel("Job");
        lj.setBounds(60,180,150,30);
        lj.setFont(new Font("Tahora", Font.PLAIN,17));
        add(lj);
        
        String str[] = {"Frand Desk Clerks", "Porters", "Housekeeping", "Kitchen Stafe", "Room Service","Chefs", "Water/Wetress", "Manager", "Accountent"};
         cb = new JComboBox(str);
        cb.setBounds(200, 180, 150, 30);
        cb.setBackground(Color.white);
        add(cb);
        
         JLabel ls= new JLabel("Salary");
        ls.setBounds(60, 230, 150, 30);
        ls.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(ls);
        
         tfs = new JTextField();
        tfs.setBounds(200, 230, 150, 30);
        add(tfs);
        
         JLabel lp = new JLabel("Phone");
        lp.setBounds(60, 280, 150, 30);
        lp.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lp);
        
         tfp = new JTextField();
        tfp.setBounds(200, 280, 150, 30);
        add(tfp);
        
         JLabel laa = new JLabel("Adhar");
        laa.setBounds(60, 330, 150, 30);
        laa.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(laa);
        
        tfaa = new JTextField();
        tfaa.setBounds(200, 330, 150, 30);
        add(tfaa);
        
        JLabel le = new JLabel("Email");
        le.setBounds(60, 380, 150, 30);
        le.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(le);
        
         tfe = new JTextField();
        tfe.setBounds(200, 380, 150, 30);
        add(tfe);
        
        sb = new JButton("Submit");
        sb.setBackground(Color.black);
        sb.setForeground(Color.white);
        sb.setBounds(200, 450, 150, 30);
        sb.addActionListener(this);
        add(sb);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380, 60, 450, 370);
        add(image);
        
        
        
        getContentPane().setBackground(Color.white);
        setBounds(350, 200, 850, 540);
        setVisible(true);       
} 
    public void actionPerformed(ActionEvent ae){
        
        String name = tfn.getText();
        String age = tfa.getText();
        String salary = tfs.getText();
        String phone = tfp.getText();
        String adhar= tfaa.getText();
        String email = tfe.getText();
        
        String gender = null;
        
        if(rbm.isSelected()){
            gender = "male";
        }else if(rbf.isSelected()){
            gender = "female";
        }
        
        String job = (String) cb.getSelectedItem();
        
        try{
            Conn Conn = new Conn();
            
            String query = "Insert  into employee value('"+name+"' ,'"+age+"' ,'"+gender+"' ,'"+job+"' ,'"+salary+"' ,'"+adhar+"' ,'"+phone+"','"+email+"')";
            Conn.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "employee added succesfull");
            
            setVisible(false);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    public static void main(String[] avg){
     new AddEmployee();
    }
}
