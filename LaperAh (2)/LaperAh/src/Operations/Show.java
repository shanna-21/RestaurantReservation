package Operations;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Show 
{
	public static void ShowEmployee(Connection conn, String query)
	{
		try
		{
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next())
			{
				System.out.println("EmployeeID : " + rs.getInt("EmployeeID"));
				System.out.println("EmployeeName : " + rs.getString("EmployeeName"));
				System.out.println("BranchID : " + rs.getString("BranchID"));
				System.out.println();
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public static void ShowRestaurant(Connection conn, String query)
	{
		try
		{
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next())
			{
				System.out.println("RestaurantID : " + rs.getInt("RestaurantID"));
				System.out.println("BranchID : " + rs.getString("BranchID"));
				System.out.println();
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public static void ShowTransactionDetails(Connection conn, String query, int TransactionID)
	{
		try
		{
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next())
			{
				System.out.println("TransactionDetailsID : " + rs.getInt("TransactionDetailsID"));
				System.out.println("MenuID : " + rs.getString("MenuID"));
				System.out.println("Amount : " + rs.getString("Amount"));
				System.out.println("TransactionID : " + rs.getString("TransactionID"));
				System.out.println();
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
