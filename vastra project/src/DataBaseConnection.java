import java.io.*;
import java.sql.*;

class DataBaseConnection 
{

	public static void main(String[] args) 
	{
		String username="root";
		
		String password="tiger";
		
		String path="jdbc:mysql://localhost:3306/vastracollection";
		
		try
		{
			// step 2 : open connection
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection conn=DriverManager.getConnection(path,username,password);
			System.out.println("Connected to database Sucessfully!!!");
		}
		
		catch(Exception e)
		{
			System.out.println("Unable to connect database"+e);
			
		}

	}

}
