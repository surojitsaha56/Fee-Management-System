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
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;

public class FeesDue extends JFrame implements ActionListener
{
    private JTable table;
    private JTextField tf1;
    private JButton b1;
    private JScrollPane sp;
    private JLabel l1;
    
    public static void main(String args[])
    {
        new FeesDue().setVisible(true);
    }
    
    public void fees()
    {
        try
        {
            conn con =  new conn();
            String sql = "select name, mobile_number, java, python, ds, aoa, fees, balance from student_details where balance>0";
            PreparedStatement st = con.c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e)
        {
            System.out.print(e);
        }
    }
    public FeesDue()
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
        
        l1 = new JLabel("Fees Due");
	l1.setFont(new Font("Times New Roman", Font.BOLD , 30));
	l1.setBounds(350, 20, 400, 47);
	add(l1);
        
        fees();
        
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
            System.out.print(e);
        }
    }
}


    
