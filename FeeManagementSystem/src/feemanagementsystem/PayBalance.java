package feemanagementsystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class PayBalance extends JFrame implements ActionListener
{
    private JButton b1, b2, b3;
    private JTextField tf1, tf2, tf3, tf4, tf5;
    public int balance1;
    public int balance2;
    public int balance;
    public String strbal;
    public static void main(String args[])
    {
        new PayBalance().setVisible(true);
    }
    
    public PayBalance()
    {
        super("Pay Balance");
        setBounds(350, 50, 500, 620);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel l1=new JLabel("Enter student ID or Mobile no.");
        l1.setBounds(100, 60, 200, 25);
        add(l1);
        
        JLabel l2=new JLabel("Student ID");
        l2.setBounds(100, 110, 100, 25);
        add(l2);
        
        JLabel l3=new JLabel("Mobile no.");
        l3.setBounds(100, 160, 100, 25);
        add(l3);
        
        JLabel l4=new JLabel("Balance");
        l4.setBounds(100, 270, 100, 25);
        add(l4);
        
        JLabel l6=new JLabel("Payment");
        l6.setBounds(100, 320, 100, 25);
        add(l6);
        
        JLabel l5=new JLabel("Updated Balance");
        l5.setBounds(100, 440, 150, 25);
        add(l5);
        
        tf1= new JTextField();
        tf1.setBounds(200, 110, 150, 25);
        add(tf1);
        
        tf2= new JTextField();
        tf2.setBounds(200, 160, 150, 25);
        add(tf2);
        
        tf3= new JTextField();
        tf3.setBounds(200, 270, 150, 25);
        tf3.setEditable(false);
        add(tf3);
        
        tf5=new JTextField();
        tf5.setBounds(200, 320, 150, 25);
        add(tf5);
        
        tf4= new JTextField();
        tf4.setBounds(200, 440, 150, 25);
        add(tf4);
        
        b1= new JButton("Search");
        b1.setBounds(175, 210, 100, 40);
        b1.addActionListener(this);
        add(b1);
        
        b2= new JButton("Pay");
        b2.setBounds(175, 370, 100, 40);
        b2.addActionListener(this);
        add(b2);
        
        b3= new JButton("Back");
        b3.setBounds(175, 490, 100, 40);
        add(b3);
        b3.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent ae) 
    {
            if(ae.getSource() == b1)
            {
                try
                {
                    conn con = new conn();
                    String sql = "select * from student_details where "
                            + "student_id = ? or mobile_number =?";
                    PreparedStatement ps = con.c.prepareStatement(sql);
                    ps.setString(1, tf1.getText());
                    ps.setString(2, tf2.getText());

                    ResultSet rs = ps.executeQuery();

                    while (rs.next()) 
                    {
                        tf3.setText(rs.getString("balance"));
                    }
                    ps.close();
                    rs.close();
                }
                catch(Exception e)
                {
                    System.out.print(e);
                }
            }
            
            if(ae.getSource()==b2)
            {
                try
                {
                    balance1=Integer.parseInt(tf3.getText());
                    balance2=Integer.parseInt(tf5.getText());
                    balance=balance1-balance2;
                    strbal=Integer.toString(balance);
                    
                    if(balance>0)
                    {
                        tf4.setText(strbal);
                    }
                   
                    
                    String s1=tf1.getText();
                    String s2=tf2.getText();
                    
                    conn con = new conn();
                    
                    if(balance>=0)
                    {
                        String sql = "update student_details set balance = '" +strbal
                            + "' where student_id = '"+ s1 +"' or mobile_number = '"+ s2 +"' ";
                        PreparedStatement ps = con.c.prepareStatement(sql);


                        int rs = ps.executeUpdate();
                        if (rs > 0)
                        {
                            JOptionPane.showMessageDialog(null, "Successfully Added");
                            tf1.setText("");
                            tf2.setText("");
                            tf3.setText("");
                            tf4.setText("");
                            tf5.setText("");
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "Not Added");
                        }
                        ps.close();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Extra money given");
                        tf4.setText("");
                    }
                    
                    
                    
                }
                catch(Exception e)
                {
                    System.out.print(e);
                }
            }

           
           if(ae.getSource()==b3)
           {
               this.setVisible(false);
               new HomePage().setVisible(true);
           }
       }
}
