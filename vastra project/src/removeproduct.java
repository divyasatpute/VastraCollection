import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

	public class removeproduct implements ActionListener
	{

		JLabel bg,l1;
		JButton remove,cancel;
		JTextField t1;
		static JFrame removeframe;
		removeproduct()
		{
			StartPage.startframe.setVisible(false);
			removeframe=new JFrame();
			Font font =new Font("Bookman Old Style",Font.BOLD,20);
			removeframe.setSize(1200,800);
			removeframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			removeframe.setLayout(new FlowLayout()); // Using FlowLayout instead of null layout
		    
		    
		    
		    bg=new JLabel();
			bg.setIcon(new ImageIcon("E:\\VastraCollection\\removebg.jpg"));
			removeframe.add(bg);
			
		    l1 = new JLabel("Enter Product ID ");
		    l1.setBounds(500,50,200,50);
		    l1.setFont(font);
	        bg.add(l1);
	        
		    t1=new JTextField(10);
		    t1.setBounds(490,100,200,30);
		    bg.add(t1);
		    
		    remove=new JButton();
		    remove.setIcon(new ImageIcon("E:\\VastraCollection\\remove.jpg"));
		    remove.setBounds(500,150,60,40);
		    remove.addActionListener(this);
		    bg.add(remove);
		     
		    cancel=new JButton();
		    cancel.setIcon(new ImageIcon("E:\\VastraCollection\\exit.jpg"));
		    cancel.setBounds(610,150,60,40);
		    cancel.addActionListener(this);
		    bg.add(cancel);
		    
		    removeframe.setVisible(true);
		}
		public void actionPerformed(ActionEvent e)
		{
			Object ch=e.getSource();
			
			if(e.getSource()==remove)
			{
				String id=t1.getText();
				if(id.equalsIgnoreCase(""))			
						{
							JOptionPane.showMessageDialog(null, "Please Enter ID");		
						}
						else
						{
							try
							{
								DAO db=new DAO();
								Connection conn=db.getConnection();
								int no=Integer.parseInt(id);
								String deleteQuery="delete from entry where id=?";
								PreparedStatement preparedStatement;	
								preparedStatement=conn.prepareStatement(deleteQuery);
								preparedStatement.setString(1,id+"");
								
								int count=preparedStatement.executeUpdate();
						
							if (count==0)
							{
								JOptionPane.showMessageDialog(null,"No Record Found");
								System.out.println("No Record Found with ID=!!!!"+id);
							}
				
							else
							{
								JOptionPane.showMessageDialog(null, "Product Deleted Sucessfully ");
								System.out.println("Total"+count+"Records Deleted!!!");
							}
							}
							catch(Exception e1)
							{
							System.out.println(e1);
							}
						}
			}
	
		else
			if(e.getSource()==cancel)
			{
				removeframe.setVisible(false);
				StartPage.startframe.setVisible(true);	
			}
			
		}
		    public static void main(String[] args) 
			{
				removeproduct obj=new removeproduct();
			}
}