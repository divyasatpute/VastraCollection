import java.awt.FlowLayout;

import javax.swing.*;


public class ChangePin extends JFrame
{
 JLabel oldpass,newpass,confpass;
 JButton change,cancel;
 JTextField t1;
 JPasswordField t2,t3;
 
 ChangePin()
 {
	 setSize(350, 350);
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     setLayout(new FlowLayout()); // Using FlowLayout instead of null layout
     
     oldpass = new JLabel("Enter Old Password :");
     add(oldpass);
     t1=new JTextField(10);
     add(t1);
     
     newpass = new JLabel("Enter New Password :");
     add(newpass);
     t2=new JPasswordField(10);
     add(t2);
     
     confpass = new JLabel("Re-Enter New Password :");
     add(confpass);
     t3=new JPasswordField(10);
     add(t3);
     
     change=new JButton("Change Password");
     add(change);
     
     cancel=new JButton("Cancel");
     add(cancel);
     
     setVisible(true);
     
 }
	public static void main(String[] args) 
	{
		ChangePin obj=new ChangePin();
		
	}

}
