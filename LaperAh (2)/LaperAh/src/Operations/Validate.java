package Operations;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Validate 
{
	public static Boolean ValidateTransactionID(Connection conn, String query, String validate)
	{
		try
		{
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next())
			{
				if(rs.getString("TransactionID").equals(validate) == true)
				{
					return true;
				}
				else
				{
					
				}
			}
		
			return false;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
	}
	
	public static Boolean ValidateMenuName(Connection conn, String query, String validate)
	{
		try
		{
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next())
			{
				if(rs.getString("MenuName").equals(validate) == true)
				{
					return true;
				}
				else
				{
					
				}
			}
		
			return false;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
	}
	
}
