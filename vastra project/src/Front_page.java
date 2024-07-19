import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.*;


public class Front_page implements ActionListener
{
	JButton login,Changepin,cancel;
	JLabel l1,l2,l3;
	JPasswordField t1; 
	static JFrame Frontframe;
	
Front_page()
{
	Frontframe=new JFrame();
	//Frontframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	Frontframe.setLayout(new FlowLayout());
	Frontframe.setSize(1200,800);

	
	l1=new JLabel();
	l1.setIcon(new ImageIcon("E:\\VastraCollection\\banner1.png"));
	Frontframe.add(l1);
	
	//l2=new JLabel();
	//l2.setIcon(new ImageIcon("E:\\VastraCollection\\label1.png"));
	//l2.setBounds(400,400,400,219);
	//l1.add(l2);
	
	l3=new JLabel();
	l3.setIcon(new ImageIcon("E:\\VastraCollection\\pin.png"));
	l3.setBounds(390,260,50,50);
	l1.add(l3);
	
	t1=new JPasswordField();
	t1.setBounds(470,270,150,40);
	l1.add(t1);
	
	login =new JButton("Login");
	login.setBounds(390,400,100,40);
	login.addActionListener(this);
	//save.setEnabled(false);
	l1.add(login);
	
	
	Changepin=new JButton("Change PIN");
	Changepin.setBounds(550,400,100,40);
	Changepin.addActionListener(this);
	l1.add(Changepin);
	
	Frontframe.setVisible(true);	
}
public void actionPerformed(ActionEvent e)
{
	Object ch=e.getSource();
	
	if(e.getSource()==login)
	{
		
		String id="1234";
		t1.getText();
		if(id.equalsIgnoreCase(""))
		{
			JOptionPane.showMessageDialog(null, "Please Enter Values");		
		}
		else
		{
			if(t1.getText().equalsIgnoreCase(id))
			{
				StartPage obj=new StartPage();
			}
		}
		
			
	}
	else
	if(e.getSource()==Changepin)
	{
	  System.exit(0);	
	}
	
}

	public static void main(String[] args) 
	{
	Front_page fp=new Front_page();
	
	}
	
		
	}
