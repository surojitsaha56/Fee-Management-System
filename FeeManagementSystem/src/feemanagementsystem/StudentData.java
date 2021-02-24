package feemanagementsystem;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;


public class StudentData extends JFrame implements ActionListener
{
    private JScrollPane sp;
    private JTable table;
    private JButton b1;
    private JLabel l1;
    
   
    
    public static void main(String args[])
    {
        new StudentData().setVisible(true);
       
    }
    
    public void data()
    {
        
        
        String S1, S2;
        S1=SearchStudent.s1;
        S2=SearchStudent.s2;
        
        try
        {
            conn con =  new conn();
            String sql = "select student_id, name, mobile_number, address, "
                    + "institution, doa, java, python, ds, aoa from "
                    + "student_details where student_id= ? or mobile_number= ? limit 1";
            PreparedStatement st = con.c.prepareStatement(sql);
            st.setString(1, S1);
            st.setString(2, S2);
            ResultSet rs = st.executeQuery();
            
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e)
        {
            System.out.print(e);
        }
    }
    
    public StudentData()
    {
        setBounds(200, 100, 890, 475);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        sp = new JScrollPane();
	sp.setBounds(80, 100, 725, 250);
	add(sp);
        
        table = new JTable();
        
        sp.setViewportView(table);
        
        b1 = new JButton("Back");
        b1.setBounds(705, 375, 100, 40);
        b1.addActionListener(this);
	add(b1);
        
        l1 = new JLabel("Student Data");
	l1.setFont(new Font("Times New Roman", Font.BOLD , 30));
	l1.setBounds(350, 20, 400, 47);
	add(l1);
        
        data();
    }

    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        try
        {
            if(ae.getSource()==b1)
            {
                this.setVisible(false);
                new HomePage().setVisible(true);
            }
        }
        catch(Exception e)
        {
            
        }
    }
}
