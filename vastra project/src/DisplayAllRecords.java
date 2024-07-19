import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class DisplayAllRecords 
{
static String rows[][]=new String [100][7];
static int row=0;

DisplayAllRecords()
{
 
		try
		{
		DAO db=new DAO();
		Connection conn=db.getConnection();
		
		String selectQuery="select * from entry";
		   
		PreparedStatement preparedStatement=conn.prepareStatement(selectQuery);
		ResultSet result=preparedStatement.executeQuery();
		
		while(result.next())	
			
		{
		for(int i=0;i<6;i++)
			rows[row][i]=result.getString((i+1));
			row++;
		}
		ViewCustomer.populateArray(rows);
		//ViewOneUser.populateArray();
	}
	   catch(Exception e)
	   {
		   System.out.println(e);
	   }
	   }
		
		public static void main(String[] args) {
			DisplayAllRecords obj=new DisplayAllRecords();
		}
}

	
