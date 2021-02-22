package feemanagementsystem;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;

public class NewStudentForm extends JFrame implements ActionListener, ItemListener
{

    private JPanel contentPane;
    private JTextArea ta1;
    private JCheckBox cb1, cb2, cb3, cb4;
    private JComboBox c1;
    String options1[]={"Cash", "Cheque"};
    private JTextField t2, t3, t4, t6, t7, t8, t9, t10, t11;
    private JButton b1,b2;
    private JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14;
 
    public final int javaf=5000;
    public final int pythonf=6000;
    public final int dsf=5000;
    public final int aoaf=7000;
    public static int final_fees;
    public static int balance;
    
    public String jVerdict="NO";
    public String pVerdict="NO";
    public String dVerdict="NO";
    public String aVerdict="NO";

    public static void main(String[] args) 
    {
	new NewStudentForm().setVisible(true);
			
    }

    public NewStudentForm() 
    {
        setBounds(200, 50, 875, 600);
	contentPane = new JPanel();
	setContentPane(contentPane);
        contentPane.setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Border blackline = BorderFactory.createLineBorder(Color.gray);
        
        l1 = new JLabel("Student Details");
        l1.setFont(new Font("Times New Roman", Font.BOLD, 30));
	l1.setBounds(120, 60, 200, 50);
	contentPane.add(l1);

	l2 = new JLabel("Student ID");
	l2.setBounds(100, 130, 100, 25);
	contentPane.add(l2);

	l3 = new JLabel("Name");
	l3.setBounds(100, 180, 100, 25);
	contentPane.add(l3);

	l4 = new JLabel("Mobile number");
	l4.setBounds(100, 230, 100, 25);
	contentPane.add(l4);
        
        l5 = new JLabel("Address");
	l5.setBounds(100, 280, 100, 25);
	contentPane.add(l5);
        
        l6=new JLabel("School/College");
        l6.setBounds(100, 400, 100, 25);
        contentPane.add(l6);

	t2 = new JTextField();
	t2.setBounds(200, 130, 157, 25);
	contentPane.add(t2);
	t2.setColumns(10);

	t3 = new JTextField();
	t3.setColumns(10);
	t3.setBounds(200, 180, 157, 25);
	contentPane.add(t3);

	t4 = new JTextField();
	t4.setColumns(10);
	t4.setBounds(200, 230, 157, 25);
	contentPane.add(t4);

	ta1 = new JTextArea();
	ta1.setColumns(10);
	ta1.setBounds(200, 280, 157, 100);
        ta1.setBorder(blackline);
        ta1.setVisible(true);
	contentPane.add(ta1);
        
        t6=new JTextField();
        t6.setBounds(200, 400, 157, 25);
        contentPane.add(t6);
        
        /*New Panel*/
        
        JPanel panel = new JPanel();
        panel.setBorder(blackline);
	panel.setBounds(50, 38, 345, 430);
	contentPane.add(panel);

	l7 = new JLabel("Fee Details");
        l7.setFont(new Font("Times New Roman", Font.BOLD, 30));
	l7.setBounds(550, 60, 200, 50);
	contentPane.add(l7);

	l8 = new JLabel("Date");
	l8.setBounds(480, 130, 100, 25);
	contentPane.add(l8);

	l9 = new JLabel("Subjects");
	l9.setBounds(480, 180, 100, 25);
	contentPane.add(l9);

        cb1=new JCheckBox("Java");
        cb1.setBounds(480, 200, 75, 50);
        contentPane.add(cb1);
        cb1.addItemListener(this);

        cb2=new JCheckBox("Python");
        cb2.setBounds(555, 200, 75, 50);
        contentPane.add(cb2);
        cb2.addItemListener(this);
        
        cb3=new JCheckBox("DS");
        cb3.setBounds(640, 200, 75, 50);
        contentPane.add(cb3);
        cb3.addItemListener(this);
        
        cb4=new JCheckBox("AOA");
        cb4.setBounds(715, 200, 75, 50);
        contentPane.add(cb4);
        cb4.addItemListener(this);
        
        l10 = new JLabel("Fees");
	l10.setBounds(480, 250, 100, 25);
	contentPane.add(l10);
        
        l11 = new JLabel("Advance");
	l11.setBounds(480, 300, 100, 25);
	contentPane.add(l11);
        
        l12 = new JLabel("Payment Method");
	l12.setBounds(480, 350, 100, 25);
	contentPane.add(l12);
        
        l13 = new JLabel("Cheque No.");
	l13.setBounds(480, 400, 100, 25);
	contentPane.add(l13);
        l13.setVisible(false);
        
        l14 = new JLabel("Bank");
	l14.setBounds(480, 450, 100, 25);
	contentPane.add(l14);
        l14.setVisible(false);
        
	t7 = new JTextField();
	t7.setColumns(10);
	t7.setBounds(580, 130, 157, 25);
	contentPane.add(t7);
        
        t11 = new JTextField();
	t11.setColumns(10);
	t11.setBounds(580, 250, 157, 25);
        t11.setEditable(false);
	contentPane.add(t11);
        
        t8 = new JTextField();
	t8.setColumns(10);
	t8.setBounds(580, 300, 157, 25);
	contentPane.add(t8);
        
        //cheque no
        t9 = new JTextField();
	t9.setBounds(580, 400, 157, 25);
        contentPane.add(t9);
        t9.setVisible(false);
        
        //bank
        t10 = new JTextField();
	t10.setBounds(580, 450, 157, 25);
	contentPane.add(t10);
        t10.setVisible(false);
        
        c1 = new JComboBox();
        c1.setModel(new DefaultComboBoxModel(options1));
	c1.setBounds(600, 350, 157, 25);
        String s1=(String)c1.getSelectedItem();
	contentPane.add(c1);
        c1.addItemListener(this);
        
        JPanel panel_1 = new JPanel();
	panel_1.setBorder(blackline);
	panel_1.setBounds(430, 38, 378, 500);
	contentPane.add(panel_1);
        
	b1= new JButton("Add");
        b1.setBounds(50, 490, 100, 40);
        contentPane.add(b1);
        b1.addActionListener(this);
        
        b2= new JButton("Back");
        b2.setBounds(295, 490, 100, 40);
        contentPane.add(b2);
        b2.addActionListener(this);
    }
    
    @Override
    public void itemStateChanged(ItemEvent e) 
    {
        try
        {
            if(e.getSource()==cb1)
            {
                if(e.getStateChange()==1)
                {
                    jVerdict="YES";
                    final_fees=final_fees+javaf;
                }
                else
                {
                    jVerdict="NO";
                    final_fees=final_fees-javaf;
                }
            }
            if(e.getSource()==cb2)
            {
                if(e.getStateChange()==1)
                {
                    pVerdict="YES";
                    final_fees=final_fees+pythonf;
                }
                else
                {
                    pVerdict="NO";
                    final_fees=final_fees-pythonf;
                }
            }
            if(e.getSource()==cb3)
            {
                if(e.getStateChange()==1)
                {
                    dVerdict="YES";
                    final_fees=final_fees+dsf;
                }
                else
                {
                    dVerdict="NO";
                    final_fees=final_fees-dsf;
                }
            }
            if(e.getSource()==cb4)
            {
                if(e.getStateChange()==1)
                {
                    aVerdict="YES";
                    final_fees=final_fees+aoaf;
                }
                else
                {
                    aVerdict="NO";
                    final_fees=final_fees-aoaf;
                }
            }
            String s2=Integer.toString(final_fees);
            t11.setText(s2);
            
     
            
            
            if(e.getSource()==c1)
            {
                if(c1.getSelectedItem()==options1[1])
                {
                    t9.setVisible(true);
                    t10.setVisible(true);
                    l13.setVisible(true);
                    l14.setVisible(true);
                }
                else
                {
                    t9.setVisible(false);
                    t9.setText("NO");
                    t10.setVisible(false);
                    t10.setText("NO");
                    l13.setVisible(false);
                    l14.setVisible(false);
                }
            }
        }
        catch(Exception e2)
        {
            System.out.print(e2);
        }
    }
        
    public void actionPerformed(ActionEvent ae)
    {
        
        try
        {
            conn con=new conn();
            
            if(ae.getSource()==b1)
            {
                    balance=final_fees-Integer.parseInt(t8.getText());
                    
                    if(balance<0)
                    {
                        JOptionPane.showMessageDialog(null, "Balance more than advance");
                    }
                    else
                    {
                    
                    
                
                    String sql = "insert into student_details values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement ps = con.c.prepareStatement(sql);
                    
                    ps.setString(1, t2.getText());
                    ps.setString(2, t3.getText());
                    ps.setString(3, t4.getText());
                    ps.setString(4, ta1.getText());
                    ps.setString(5, t6.getText());
                    ps.setString(6, t7.getText());
                    ps.setString(7, jVerdict);
                    ps.setString(8, pVerdict);
                    ps.setString(9, dVerdict);
                    ps.setString(10, aVerdict);
                    ps.setString(11, t11.getText());
                    ps.setString(12, t8.getText());
                    ps.setString(13, (String) c1.getSelectedItem());
                    ps.setString(14, t9.getText());
                    ps.setString(15, t10.getText());
                    ps.setString(16, Integer.toString(balance));
                    
                    
                    int rs = ps.executeUpdate();
                    if (rs > 0)
                    {
                        JOptionPane.showMessageDialog(null, "Successfully Added");
                        t2.setText("");
                        t3.setText("");
                        t4.setText("");
                        ta1.setText("");
                        t6.setText("");
                        t7.setText("");
                        t8.setText("");
                        t9.setText("");
                        t10.setText("");
                        t11.setText("");
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Not Added");
                    }
                    ps.close();

                }
                    }
            
            
            if(ae.getSource()==b2)
            {
                this.setVisible(false);
                new HomePage().setVisible(true);
            }
            con.c.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
            