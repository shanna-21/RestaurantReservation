package Operations;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import Tables.*;

public class Get
{
	public static LAStaff GetStaffData(Connection conn, String query)
	{
		try
		{
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			LAStaff tempstaff = new LAStaff();
			
			while(rs.next())
			{
				tempstaff.setEmployeeID(rs.getInt("EmployeeID"));
				tempstaff.setEmployeeName(rs.getString("EmployeeName"));
				tempstaff.setBranchID(rs.getString("BranchID"));
			}
			
			return tempstaff;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
	}
	
	public static LARestaurant GetRestaurantData(Connection conn, String query)
	{
		try
		{
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			LARestaurant tempRestaurant = new LARestaurant();
			
			while(rs.next())
			{
				tempRestaurant.setRestaurantID(rs.getInt("RestaurantID"));
				tempRestaurant.setBranchID(rs.getString("BranchID"));
			}
			
			return tempRestaurant;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
	}
	
	public static LAMenu GetMenuData(Connection conn,String query)
	{
		try
		{
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			LAMenu tempMenu = new LAMenu();
			
			while(rs.next())
			{
				tempMenu.setMenuID(rs.getInt("MenuID"));
				tempMenu.setMenuName(rs.getString("MenuName"));
				tempMenu.setMenuPrice(rs.getInt("MenuPrice"));
				tempMenu.setMenuType(rs.getString("MenuType"));
				tempMenu.setAmountOrder(rs.getInt("AmountOrdered"));
				tempMenu.setStory(rs.getString("Backstory"));
			}
			
			return tempMenu;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
	}
	
	public static LATransaction GetTransactionData(Connection conn, String query)
	{
		try
		{
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			LATransaction tempTransaction = new LATransaction();
			
			while(rs.next())
			{
				tempTransaction.setTransactionID(rs.getInt("TransactionID"));
				tempTransaction.setRestaurantID(rs.getInt("RestaurantID"));
				tempTransaction.setReservationType(rs.getString("ReservationType"));
				tempTransaction.setBookedSeats(rs.getInt("BookedSeats"));
				tempTransaction.setEmployeeID(rs.getInt("EmployeeID"));
				tempTransaction.setCustomerName(rs.getString("CustomerName"));
				tempTransaction.setBookedTables(rs.getInt("BookedTables"));
				tempTransaction.setStatus(rs.getString("Status"));
			}
			
			return tempTransaction;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
	}
	
	
	
	
	
}
