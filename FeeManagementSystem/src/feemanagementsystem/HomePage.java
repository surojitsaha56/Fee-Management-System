package feemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HomePage extends JFrame implements ActionListener
{
    private JPanel jp;
    private JLabel l1, l2;
    private JButton b1, b2, b3, b4, b5;

	public static void main(String[] args) 
        {
            new HomePage().setVisible(true);
	}
        
        public HomePage() 
        {
            super("Home");
            jp=new JPanel();
            setBounds(400, 75, 500, 500);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            
            l2=new JLabel();
            l2.setIcon(new ImageIcon("C:\\Users\\ASUS\\Documents\\NetBeansProjects\\FeeManagementSystem\\src\\feemanagementsystem\\image2.jpg"));
            jp.add(l2);
            validate();
            
            l1=new JLabel("Library Management System");
            l1.setBounds(50, 120, 400, 100);
            l1.setFont(new Font("Times New Roman", Font.BOLD, 30));
            add(l1);
            
            b1=new JButton("Add Student");
            b1.setBounds(80, 250, 130, 40);
            b1.addActionListener(this);
            add(b1);
            
            b2=new JButton("Pay Balance");
            b2.setBounds(280, 250, 130, 40);
            b2.addActionListener(this);
            add(b2);
            
            b3=new JButton("Search Student");
            b3.setBounds(80, 325, 130, 40);
            b3.addActionListener(this);
            add(b3);
            
            b4=new JButton("Fees Due");
            b4.setBounds(280, 325, 130, 40);
            b4.addActionListener(this);
            add(b4);
            
            b5=new JButton("Back");
            b5.setBounds(195, 400, 100, 40);
            b5.addActionListener(this);
            add(b5);
            
            add(jp);
            
            validate();
            
        }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()==b1)
        {
            this.setVisible(false);
            new NewStudentForm().setVisible(true);
        }
        else if(e.getSource()==b2)
        {
            this.setVisible(false);
            new PayBalance().setVisible(true);
        }
        else if(e.getSource()==b3)
        {
            this.setVisible(false);
            new SearchStudent().setVisible(true);
        }
        else if(e.getSource()==b4)
        {
            this.setVisible(false);
            new FeesDue().setVisible(true);
        }
        else if(e.getSource()==b5)
        {
            this.setVisible(false);
            new LoginPage().setVisible(true);
        }
    }
}