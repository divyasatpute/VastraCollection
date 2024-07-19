import java.sql.Connection;
import java.sql.DriverManager;


public class DAO 
{
	String username="root";
	
	String password="tiger";
	
	static final String path="jdbc:mysql://localhost:3306/vastracollection";
	
	public Connection getConnection()
	{
		Connection conn=null;
	try
	{
		// step 2 : Register JDBC Driver
		Class.forName("com.mysql.jdbc.Driver");
		
		//Step 3 : Open Connection
		conn=DriverManager.getConnection(path,username,password);
		System.out.println("Connected to database Sucessfully!!!");
	}
	
	catch(Exception e)
	{
		System.out.println("Unable to connect database"+e);
	}
		return conn;
}
}