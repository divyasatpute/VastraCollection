
		import java.awt.FlowLayout;
		import java.awt.Font;
		import java.awt.event.ActionEvent;
		import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
		import java.sql.Connection;
		import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

		import javax.swing.ImageIcon;
		import javax.swing.JButton;
		import javax.swing.JComboBox;
		import javax.swing.JFrame;
		import javax.swing.JLabel;
		import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
		import javax.swing.JTextArea;
import javax.swing.JTextField;

			public class searchproduct implements ActionListener
			{

				JLabel bg,l1;
				JButton search,cancel;
				JTextField t1;
				JTextArea resultArea;
				static JFrame searchframe;
				static String rows[][]=new String [100][7];
				static int row=0;
				
				searchproduct()
				{
					StartPage.startframe.setVisible(false);
					searchframe=new JFrame();
					Font font =new Font("Bookman Old Style",Font.BOLD,20);
					searchframe.setSize(500,500);
					//searchframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					searchframe.setLayout(new FlowLayout()); // Using FlowLayout instead of null layout
				    
		
				    bg=new JLabel();
					bg.setIcon(new ImageIcon("E:\\BugSolver Website\\Websitess\\images\\service.png"));
					searchframe.add(bg);
					
				    l1 = new JLabel("Enter Product ID ");
				    l1.setBounds(500,50,200,50);
				    l1.setFont(font);
			        bg.add(l1);
			        
				    t1=new JTextField(10);
				    t1.setBounds(490,100,200,30);
				    bg.add(t1);
				    
				    search=new JButton();
				    search.setIcon(new ImageIcon("E:\\BugSolver Website\\Websitess\\images\\search1.png"));
				    search.setBounds(500,150,120,50);
				    search.addActionListener(this);
				    bg.add(search);
				    
				    resultArea = new JTextArea(10, 30);
			        resultArea.setEditable(false);
			        JScrollPane scrollPane = new JScrollPane(resultArea);
				     		    
			        searchframe.setVisible(true);
			        
			        
			        searchframe.addWindowListener(new WindowAdapter()
					{
						public void windowClosing(WindowEvent e)
						{
							System.out.println("close");
						    searchframe.setVisible(false);
							StartPage obj=new StartPage();
						}
					});
				}
				public void actionPerformed(ActionEvent e)
				{
					Object ch=e.getSource();
					
					if(e.getSource()==search)
					{
							String searchTerm = t1.getText();
			            	searchItems(searchTerm);
					}
				}
			            	
			    void searchItems(String searchTerm) 
			      {
			    	try 
			    	{
			    	DAO db = new DAO();
					Connection conn=db.getConnection();
				
					String searchQuery="select * from entry where id=?";
					
					PreparedStatement ptstmt;
					
						ptstmt = conn.prepareStatement(searchQuery);
					ptstmt.setString(1,t1.getText());
					
					ResultSet result=ptstmt.executeQuery();
					
					if(result.next()==true)
					{
						for(int i=0;i<6;i++)
							rows[row][i]=result.getString((i+1));
							row++;
							ViewSearchUser.populateArray();
					}
					else
					{
						JOptionPane.showMessageDialog(searchframe,"Search  UnSuccessfull !!!");
					}
			    	} 
			    	catch (SQLException e) 
			    	{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					

			      }	
			    
			    		
				 public static void main(String[] args) 
					{
				    	searchproduct obj=new searchproduct();
					}
		}
