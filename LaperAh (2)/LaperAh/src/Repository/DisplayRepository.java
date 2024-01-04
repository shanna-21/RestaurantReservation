package Repository;

import java.sql.Connection;

import Operations.Show;

public class DisplayRepository 
{
	public static void DISPLAY_MAINMENU()
	{
		System.out.println("---LAPERAH EMPLOYEE CONSOLE---");
		System.out.println("1. Add New Reservation");
		System.out.println("2. Add New Orders");
		System.out.println("3. Update Customer Status");
		System.out.println("4. Checkout Customer");
		System.out.println("5. Add New Menu");
		System.out.println("6. Update or Delete Menu");
		System.out.println("7. Exit");
	}
	
	public static void DISPLAY_CHECKOUTBILL(Connection conn,String TransacID)
	{
		System.out.println("--BILL DETAILS--");
		String query3SELECTSTAR = "SELECT * FROM latransactiondetails WHERE TransactionID=";
		String query3 = query3SELECTSTAR + TransacID;
		int intTransacID = Integer.parseInt(TransacID);
		Show.ShowTransactionDetails(conn, query3, intTransacID);
	}
	
	public static void DISPLAY_EMPLOYEEDATA(Connection conn, String IDinput)
	{
		String query0SELECTSTAR = "SELECT * FROM lastaff WHERE EmployeeID =";
		String query0 = query0SELECTSTAR + IDinput;
		Show.ShowEmployee(conn, query0);
	}
	
	public static void DISPLAY_RESTAURANTLIST(Connection conn)
	{
		System.out.println("------RESTAURANT LIST------");
		Show.ShowRestaurant(conn, "SELECT * FROM larestaurant");
		System.out.println("---------------------------");
	}
	
	public static void DISPLAY_UPDATECUSTOMERMENU()
	{
		System.out.println("Change Status to : ");
		System.out.println("1. In Reserve");
		System.out.println("2. In Order");
		System.out.println("3. Finalized");
	}
}
