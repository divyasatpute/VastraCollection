import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;


public class StartPage implements ActionListener
{

	JButton add,remove,update,search,display;
	JLabel l;
	static JFrame startframe;
	
	StartPage()
	{
		Front_page.Frontframe.setVisible(false);
		startframe=new JFrame();
		startframe.setSize(1200,700);
		//startframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		startframe.setLayout(new FlowLayout()); // Using FlowLayout instead of null layout
	    
	    l=new JLabel();
	    l.setIcon(new ImageIcon("E:\\VastraCollection\\banner.png"));
	    startframe.add(l);
	    
	    
	    add=new JButton("Add Product");
	    add.setBounds(150,50,150,50);
	    add.addActionListener(this);
	    l.add(add);
	     
	    remove=new JButton("Remove Product");
	    remove.setBounds(150,150,150,50);
	    remove.addActionListener(this);
	    l.add(remove);
	    
	    update=new JButton("Update Product");
	    update.setBounds(150,250,150,50);
	    update.addActionListener(this);
	    l.add(update);
	     
	    search=new JButton("Search Product");
	    search.setBounds(150,350,150,50);
	    search.addActionListener(this);
	    l.add(search);
	    
	    display=new JButton("Display All Products");
	    display.setBounds(150,450,150,50);
	    display.addActionListener(this);
	    l.add(display);
	    
	    startframe.setVisible(true);
	    
	    
	    startframe.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				//System.out.println("close");
				startframe.setVisible(false);
				Front_page.Frontframe.setVisible(true);
			}
		});
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Object ch=e.getSource();
		
		if(e.getSource()==add)
		{
			addpage obj=new addpage();
		}
		else if(e.getSource()==remove)
		{
		    removeproduct obj=new removeproduct();
		}
		else if(e.getSource()==update)
		{
			updaterecord obj=new updaterecord();
		}
		else if(e.getSource()==search)
		{
			searchproduct obj=new searchproduct();
		}
		else if(e.getSource()==display)
		{
			DisplayAllRecords obj=new DisplayAllRecords();
		}
		
		else
			Front_page.Frontframe.setVisible(true);
			
		
	}

	public static void main(String args[]) 
	{
		StartPage obj=new StartPage();
	}

	
}
