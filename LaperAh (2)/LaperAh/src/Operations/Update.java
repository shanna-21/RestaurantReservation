package Operations;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Update 
{
	public static void UpdateTransactionStatus(Connection conn, String Status, int TransactionID)
	{
		try
		{
			PreparedStatement pt = conn.prepareStatement("UPDATE latransaction SET Status = ? WHERE TransactionID = ?");
			pt.setString(1, Status);
			pt.setInt(2, TransactionID);
			
			int i = pt.executeUpdate();
			if(i!=0)
			{
				System.out.println("Data Successfully Updated");
			}
			else
			{
				System.out.println("Failed to Insert Data");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public static void UpdateMenuString(Connection conn, String Update, String Where)
	{
		try
		{
			PreparedStatement pt = conn.prepareStatement("UPDATE lamenu SET MenuName = ? WHERE MenuName = ?");
			pt.setString(1, Update);
			pt.setString(2, Where);
			int i = pt.executeUpdate();
			if(i!=0)
			{
				System.out.println("Data Successfully Updated");
			}
			else
			{
				System.out.println("Failed to Update Data");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	public static void UpdateMenuInteger(Connection conn, int Update, String Where)
	{
		try
		{
			PreparedStatement pt = conn.prepareStatement("UPDATE lamenu SET MenuPrice = ? WHERE MenuName = ?");
			pt.setInt(1, Update);
			pt.setString(2,Where);
			int i = pt.executeUpdate();
			if(i!=0)
			{
				System.out.println("Data Successfully Updated");
			}
			else
			{
				System.out.println("Failed to Update Data");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public static void UpdateOrderedAmount(Connection conn, int Update, String Where)
	{
		try
		{
			PreparedStatement pt = conn.prepareStatement("UPDATE lamenu SET AmountOrdered = ? WHERE MenuName = ?");
			pt.setInt(1, Update);
			pt.setString(2,Where);
			int i = pt.executeUpdate();
			if(i!=0)
			{
				System.out.println("Data Successfully Updated");
			}
			else
			{
				System.out.println("Failed to Update Data");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
}
