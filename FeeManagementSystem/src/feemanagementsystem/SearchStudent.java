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

public class SearchStudent extends JFrame implements ActionListener
{
    private JButton b1, b2;
    public JTextField tf1, tf2;
    public static String s1, s2;
   
    
    public static void main(String arg[])
    {
        new SearchStudent().setVisible(true);
        
    }
    public SearchStudent()
    {
        super("Search Student");
        setBounds(350, 150, 500, 350);
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
        
        tf1= new JTextField();
        tf1.setBounds(200, 110, 150, 25);
        add(tf1);
        
        
        tf2= new JTextField();
        tf2.setBounds(200, 160, 150, 25);
        add(tf2);
        
        
        b1= new JButton("Search");
        b1.setBounds(100, 210, 100, 40);
        b1.addActionListener(this);
        add(b1);
        
        b2= new JButton("Back");
        b2.setBounds(250, 210, 100, 40 );
        add(b2);
        b2.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        if(ae.getSource()==b1)
        {
            try
            {
                conn con=new conn();
                String sql = "select * from student_details where "
                        + "student_id = ? or mobile_number =? limit 1";
                    PreparedStatement ps = con.c.prepareStatement(sql);
                    ps.setString(1, tf1.getText());
                    ps.setString(2, tf2.getText());

                    ResultSet rs = ps.executeQuery();

                    if (rs.next()) 
                    {
                        s1=tf1.getText();
                        s2=tf2.getText();
                        this.setVisible(false);
                        new StudentData().setVisible(true);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Invalid Student ID "
                                + "or Mobile number !");
                    }
            }
            catch(Exception e)
            {
                System.out.print(e);
            }
        }
            
            if(ae.getSource()==b2)
            {
                this.setVisible(false);
                new HomePage().setVisible(true);
            }
        }
        
        
    
}
