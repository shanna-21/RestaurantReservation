package Main;

import java.sql.Connection;
import java.util.Scanner;

import Operations.Get;
import Operations.Insert;
import Operations.Show;
import Repository.ValidateRepository;
import SysConnection.SysConnection;
import Tables.LARestaurant;
import Tables.LAStaff;

public class InsertReservation 
{
	static void DisplayMenu() {
		Connection conn;
		conn = SysConnection.makeDBConnection();
		
		Scanner sc = new Scanner(System.in);

		
		System.out.println("Insert EmployeeID");
		String IDinput = sc.nextLine(); 
		
		String query0SELECTSTAR = "SELECT * FROM lastaff WHERE EmployeeID =";
		String query0 = query0SELECTSTAR + IDinput;
		Show.ShowEmployee(conn, query0);
		
		System.out.println("---RESTAURANT LIST---");
		Show.ShowRestaurant(conn, "SELECT * FROM larestaurant");
		System.out.println("---------------------");
		System.out.println("Insert Reservation Location");
		
		String ResLoc = sc.nextLine();
		
		String query1SELECTSTAR = "SELECT * FROM larestaurant WHERE RestaurantID =";
		String query1 = query1SELECTSTAR + ResLoc;
		Show.ShowRestaurant(conn, query1);
		
		LAStaff tempStaff = new LAStaff();
		LARestaurant tempRestaurant = new LARestaurant();
		tempStaff = Get.GetStaffData(conn, query0);
		tempRestaurant = Get.GetRestaurantData(conn, query1);
		
		if(tempStaff.getBranchID().compareTo(tempRestaurant.getBranchID())==0)
		{
			int intResLoc = Integer.parseInt(ResLoc);
			int intIDinput = Integer.parseInt(IDinput);
			
			System.out.println("Insert Customer Name");
			String CustName = sc.nextLine();
			
			System.out.println("Insert Tables Booked");
			int TBooked = sc.nextInt();sc.nextLine();
			
			System.out.println("Insert Tables Type [Romantic, General, Family]");
			String TType = sc.nextLine();
			
			System.out.println("Insert People per Table");
			int PperT = sc.nextInt();sc.nextLine();
			
			if(ValidateRepository.VALIDATE_PperT(TType, PperT))
			{
				String tempStatus = "In Reserve";
				Insert.InsertTransaction(conn,intResLoc,TType,PperT,intIDinput,CustName,TBooked,tempStatus);
			}
			else
			{
				return;
			}
		}
		else
		{
			System.out.println("--Staff BranchID and Restaurant BranchID not Compatible--");
			return;
		}
		
		
	}
}
