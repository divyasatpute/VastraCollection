import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.*;

public class updaterecord implements ActionListener
{
	JButton update,cancel;
	JLabel title,bg,l1,l2,l3,l4,l5,l6;
	JTextField t1,t2,t3,t4,t5,t6;
	JComboBox cb;
	static JFrame updateframe;
	
	updaterecord()
	{
		Font font =new Font("Bookman Old Style",Font.BOLD,20);
		updateframe=new JFrame();
		updateframe.setSize(1200,800);
		updateframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		updateframe.setLayout(new FlowLayout()); // Using FlowLayout instead of null layout
	    
	    	//title=new JLabel();
	    	//title.setIcon(new ImageIcon("E:\\VastraCollection\\addpro.jpeg"));
			//add(title);
	    
		    bg=new JLabel();
			bg.setIcon(new ImageIcon("E:\\VastraCollection\\update.jpg"));
			updateframe.add(bg);
		
			l1=new JLabel("Enter the Product ID to Update :");
		    l1.setBounds(300, 50, 350, 50);
		    l1.setFont(font);
	        bg.add(l1);
	        
	        t1=new JTextField();
	        t1.setBounds(650, 60, 200, 30);
	        bg.add(t1);
	        
	        l2=new JLabel("Enter the New Name :");
		    l2.setBounds(300, 100, 350, 50);
		    l2.setFont(font);
	        bg.add(l2);
	        
	        t2=new JTextField();
	        t2.setBounds(650, 110, 200, 30);
	        bg.add(t2);
	        
	        l3=new JLabel("Enter the New Company :");
		    l3.setBounds(300, 150, 350, 50);
		    l3.setFont(font);
	        bg.add(l3);
	        
	        t3=new JTextField();
	        t3.setBounds(650, 160, 200, 30);
	        bg.add(t3);
	        
	        l4 = new JLabel("Enter New Product Size :");
		    l4.setBounds(300, 200, 350, 50);
		    l4.setFont(font);
		    bg.add(l4);
	        
	        String size[]={"Select size","XS","S","M","L","XL","XXL","3XL"};
	        cb= new JComboBox(size);
			cb.setBounds(650,210,200,30);
			bg.add(cb);
			
			l5 = new JLabel("Enter New Product Price :");
		    l5.setBounds(300, 250, 350, 50);
		    l5.setFont(font);
		    bg.add(l5);
		    
		    t4=new JTextField(10);
		    t4.setBounds(650, 260, 200, 30);
		    bg.add(t4);
		    
		    
		    l5 = new JLabel("Enter New Product Quantity :");
		    l5.setBounds(300, 300, 350, 50);
		    l5.setFont(font);
		    bg.add(l5);
		    
		    t5=new JTextField(10);
		    t5.setBounds(650, 310, 200, 30);
		    bg.add(t5);
		    
		    update=new JButton();
		    update.setIcon(new ImageIcon("E:\\VastraCollection\\update.png"));
		    update.setBounds(400,390,152,50);
		    update.addActionListener(this);
		    bg.add(update);
		     
		    cancel=new JButton();
		    cancel.setIcon(new ImageIcon("E:\\VastraCollection\\cancel.jpg"));
		    cancel.setBounds(650, 390, 140, 47);
		    cancel.addActionListener(this);
		    bg.add(cancel);
	        
		    updateframe.setVisible(true);
	}

@Override
public void actionPerformed(ActionEvent e) 
{
	Object ch=e.getSource();
	
	if(e.getSource()==update)
	{
		String id=t1.getText();
		String name =t2.getText();
		String company=t3.getText();
		String size="Selected : "+cb.getItemAt(cb.getSelectedIndex());
		String price =t4.getText();
		String qty=t5.getText();
		
		if(id.equalsIgnoreCase("") || name.equalsIgnoreCase("") || 
		   company.equalsIgnoreCase("")|| size.equalsIgnoreCase("")|| 
		   price.equalsIgnoreCase("") || qty.equalsIgnoreCase(""))			
		{
			JOptionPane.showMessageDialog(null, "Please Enter All Values");		
		}
		else
		{
			try
			{
			DAO db=new DAO();
			Connection conn=db.getConnection();
			int no=Integer.parseInt(id);
			String updateQuery="update entry set name=?,company=?,size=?,price=?,qty=? where id=?";
			PreparedStatement pstmt=conn.prepareStatement(updateQuery);
			pstmt.setString(1,name);
			pstmt.setString(2,company);
			pstmt.setString(3,size);
			pstmt.setString(4,price);
			pstmt.setString(5,qty);
			pstmt.setString(6,id+"");
			
			int count=pstmt.executeUpdate();
			
			if(count==0)
				JOptionPane.showMessageDialog(null, "Product ID Not Found");
				
			else
		    JOptionPane.showMessageDialog(null, "Product Updated Sucessfully");
			}
			catch (SQLException e1) 
			  {
					// TODO Auto-generated catch block
					e1.printStackTrace();
			  }
		}
	}
	
		else
			if(e.getSource()==cancel)
			{
				updateframe.setVisible(false);
				StartPage.startframe.setVisible(true);	
			}
			
		}
	
public static void main (String args[])
{
	updaterecord obj =new updaterecord();
}
}