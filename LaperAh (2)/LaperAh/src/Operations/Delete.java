package Operations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Delete 
{	
	public static void DeleteMenu(Connection conn,String MenuName)
	{
		try
		{
			PreparedStatement pt = conn.prepareStatement("DELETE FROM lamenu WHERE MenuName = ?");
			pt.setString(1, MenuName);
			int i = pt.executeUpdate();
			if(i!=0)
			{
				System.out.println("Data Successfully deleted");
			}
			else
			{
				System.out.println("Failed to delete Data");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}