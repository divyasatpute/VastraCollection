import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.*;
public class addpage implements ActionListener
{

	JLabel bg,l1,l2,l3,l4,l5,l6;
	JButton add,cancel;
	JTextField t1,t2,t3,t4,t5;
	JComboBox cb;
	static JFrame addframe;
	
	addpage()
	{
		StartPage.startframe.setVisible(false);
		addframe=new JFrame();
		Font font =new Font("Bookman Old Style",Font.BOLD,20);
		addframe.setSize(1200,800);
		addframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addframe.setLayout(new FlowLayout()); // Using FlowLayout instead of null layout
	    
	    
	    
	    bg=new JLabel();
		bg.setIcon(new ImageIcon("E:\\VastraCollection\\addpro.jpeg"));
		addframe.add(bg);
		
	    l1 = new JLabel("Enter Product ID :");
	    l1.setBounds(550, 50, 200, 50);
	    l1.setFont(font);
        bg.add(l1);
        
	    t1=new JTextField(10);
	    t1.setBounds(850, 60, 200, 30);
	    bg.add(t1);
	    
	    l2 = new JLabel("Enter Product Name :");
	    l2.setBounds(550, 100, 250, 50);
	    l2.setFont(font);
	    bg.add(l2);
	    
	    t2=new JTextField(10);
	    t2.setBounds(850, 110, 200, 30);
	    bg.add(t2);
	    
	    l3 = new JLabel("Enter Product Company :");
	    l3.setBounds(550, 150, 300, 50);
	    l3.setFont(font);
	    bg.add(l3);
	    
	    t3=new JTextField(10);
	    t3.setBounds(850, 160, 200, 30);
	    bg.add(t3);
	    
	    l4 = new JLabel("Enter Product Size :");
	    l4.setBounds(550, 200, 300, 50);
	    l4.setFont(font);
	    bg.add(l4);
	    
	    String size[]={"Select size","XS","S","M","L","XL","XXL","3XL"};
        cb= new JComboBox(size);
		cb.setBounds(850,210,200,30);
		bg.add(cb);
		
	    
	    
	    l5 = new JLabel("Enter Product Price :");
	    l5.setBounds(550, 250, 300, 50);
	    l5.setFont(font);
	    bg.add(l5);
	    
	    t4=new JTextField(10);
	    t4.setBounds(850, 260, 200, 30);
	    bg.add(t4);
	    
	    
	    l6 = new JLabel("Enter Product Quantity :");
	    l6.setBounds(550, 300, 300, 50);
	    l6.setFont(font);
	    bg.add(l6);
	    
	    t5=new JTextField(10);
	    t5.setBounds(850, 310, 200, 30);
	    bg.add(t5);
	    
	    add=new JButton();
	    add.setIcon(new ImageIcon("E:\\VastraCollection\\add.jpg"));
	    add.setBounds(650, 390, 145,47);
	    add.addActionListener(this);
	    bg.add(add);
	     
	    cancel=new JButton();
	    cancel.setIcon(new ImageIcon("E:\\VastraCollection\\cancel.jpg"));
	    cancel.setBounds(850, 390, 140, 47);
	    cancel.addActionListener(this);
	    bg.add(cancel);
	    
	    addframe.setVisible(true);
	    
	    
	}
	
	public void actionPerformed(ActionEvent e)
	{
		Object ch=e.getSource();
		
		if(e.getSource()==add)
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
				DAO db=new DAO();
				  Connection conn=db.getConnection();
				  int no=Integer.parseInt(id);
				  String inserQuery="insert into entry values(?,?,?,?,?,?)";
				  PreparedStatement preparedStatement;
				  
				  try 
				  {
				  preparedStatement=conn.prepareStatement(inserQuery);
				  preparedStatement.setString(1,id+"");
				  preparedStatement.setString(2,name);
				  preparedStatement.setString(3,company);
				  preparedStatement.setString(4,size);
				  preparedStatement.setString(5,price);
				  preparedStatement.setString(6,qty);
				  
				  preparedStatement.executeUpdate();
				  
				 System.out.println("Data Sucessfully Inserted!!!");
				  
				 JOptionPane.showMessageDialog(null, "Product Added Sucessfully ");	
				  } catch (SQLException e1) 
				  {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				  
			}
				
		}
		else
		if(e.getSource()==cancel)
		{
			addframe.setVisible(false);
			
			StartPage.startframe.setVisible(true);
			
		  //System.exit(0);	
		}
	}
	
	public static void main(String[] args) 
	{
		addpage obj=new addpage();
	}

	

}
