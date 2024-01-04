package Operations;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Insert 
{
	public static void InsertTransaction(Connection conn, int RestaurantID, String ReservationType, int BookedSeats, int EmployeeID, String CustomerName, int BookedTables, String Status)
	{
		try
		{
			PreparedStatement pt = conn.prepareStatement("INSERT INTO latransaction (RestaurantID,ReservationType,BookedSeats,EmployeeID,CustomerName,BookedTables,Status) VALUES (?,?,?,?,?,?,?)");
			
			pt.setInt(1, RestaurantID);
			pt.setString(2, ReservationType);
			pt.setInt(3, BookedSeats);
			pt.setInt(4, EmployeeID);
			pt.setString(5, CustomerName);
			pt.setInt(6, BookedTables);
			pt.setString(7, Status);
			
			int i = pt.executeUpdate();
			if(i!=0)
			{
				System.out.println("Data Successfully Inserted");
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
	
	public static void InsertMenu(Connection conn, String MenuName, int MenuPrice, String MenuType, int AmountOrdered, String Backstory)
	{
		try
		{
			PreparedStatement pt = conn.prepareStatement("INSERT INTO lamenu (MenuName,MenuPrice,MenuType,AmountOrdered,Backstory) VALUES (?,?,?,?,?)");
			
			pt.setString(1, MenuName);
			pt.setInt(2, MenuPrice);
			pt.setString(3, MenuType);
			pt.setInt(4, AmountOrdered);
			pt.setString(5, Backstory);
			
			int i = pt.executeUpdate();
			if(i!=0)
			{
				System.out.println("Data Successfully Inserted");
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
	
	public static void InsertTransactionDetails(Connection conn, int menuID, int amount, int transactionID)
	{
		try
		{
			PreparedStatement pt = conn.prepareStatement("INSERT INTO latransactiondetails (MenuID,Amount,TransactionID) VALUES (?,?,?)");
			
			pt.setInt(1, menuID);
			pt.setInt(2, amount);
			pt.setInt(3, transactionID);
			
			int i = pt.executeUpdate();
			if(i!=0)
			{
				System.out.println("Data Successfully Inserted");
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
	
	
	
}
