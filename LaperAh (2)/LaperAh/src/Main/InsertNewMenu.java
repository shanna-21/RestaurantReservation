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
import Tables.LATransaction;

public class InsertNewMenu 
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
		
		System.out.println("Insert  Location");
		
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
			System.out.println("Insert New Menu Name");
			String newMenuName = sc.nextLine();
			
			System.out.println("Insert New Menu Price");
			int newMenuPrice = sc.nextInt();sc.nextLine();
			
			System.out.println("Insert New Menu Type");
			String newMenuType = sc.nextLine();
			
			if(newMenuType.equals("Special") == true)
			{
				
				if(tempStaff.getBranchID().equals("JAK") || tempStaff.getBranchID().equals("BAN") || tempStaff.getBranchID().equals("BAL"))
				{
					// do nothing
				}
				else
				{
					System.out.println("Cannot Add Menu : ");
					System.out.println("Employee Not in Jakarta, Bandung and Bali");
					return;
				}
			}
			else if(newMenuType.contains("Local") == true)
			{
				
				if(tempStaff.getBranchID().equals("SUR") || tempStaff.getBranchID().equals("SAM") || tempStaff.getBranchID().equals("PAD"))
				{
					// do nothing
				}
				else
				{
					System.out.println("Cannot Add Menu : ");
					System.out.println("Employee Not in Surabaya, Samarinda and Padang");
					return;
				}
			}
			else
			{
				// do nothing
			}
			
			int newMenuOrderedAmount = 0;
			String newMenuBackstory = ValidateRepository.VALIDATE_MENUTYPE(newMenuType);
			
			Insert.InsertMenu(conn, newMenuName, newMenuPrice, newMenuType, newMenuOrderedAmount, newMenuBackstory);
			
			return;
		}
		else
		{
			System.out.println("--Staff BranchID and Restaurant BranchID not Compatible--");
			return;
		}
		
		
	}
}
