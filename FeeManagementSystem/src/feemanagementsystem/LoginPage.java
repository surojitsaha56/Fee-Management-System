package feemanagementsystem;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class LoginPage extends JFrame implements ActionListener
{
    private JLabel l1, l2;
    private JTextField t1, t2;
    private JPasswordField p1;
    private JButton b1;
    final static String var1="Surojit";
    final static String var2="12345";
    
    public static void main(String[] args) 
    {
        new LoginPage().setVisible(true);
    }

    public LoginPage() 
    {
        super("Login");
        setBounds(350, 150, 500, 350);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
        l1 = new JLabel("Username ");
	l1.setBounds(100, 80, 100, 25);
	add(l1);
        
	l2 = new JLabel("Password ");
	l2.setBounds(100, 130, 100, 25);
	add(l2);
        
	t1 = new JTextField();
	t1.setBounds(210, 80, 157, 25);
	add(t1);
	
	p1 = new JPasswordField();
	p1.setBounds(210, 130, 157, 25);
	add(p1);

        //Login Button
	b1 = new JButton("Login");
	b1.addActionListener(this);
	b1.setBounds(185, 200, 100, 40);
	add(b1);

	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
        
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == b1)
        {
            try 
            {
                if (t1.getText().equals(var1) && p1.getText().equals(var2)) 
                {
                    this.setVisible(false);
                    new HomePage().setVisible(true);
                } 
                else
                {
                    JOptionPane.showMessageDialog(null, "Username/Password Incorrect");
                }
			
            } 
            catch (Exception e2) 
            {
           
            }
        }
        
    }
}

