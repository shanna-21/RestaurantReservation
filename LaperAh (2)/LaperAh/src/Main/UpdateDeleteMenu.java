package Main;

import java.sql.Connection;
import java.util.Scanner;

import Operations.Delete;
import Operations.Get;
import Operations.Update;
import Operations.Validate;
import SysConnection.SysConnection;
import Tables.LAMenu;

public class UpdateDeleteMenu 
{
	public static void DisplayMenu() {
		Connection conn;
		conn = SysConnection.makeDBConnection();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Select menu name: ");
		String MenuName = sc.nextLine();
		
		String queryValidateMenuName = "SELECT * FROM lamenu";
		Boolean isMenuNameValid = Validate.ValidateMenuName(conn, queryValidateMenuName, MenuName);
		
		if(isMenuNameValid == true) {
			
			String query2SELECTSTAR = "SELECT * FROM lamenu WHERE MenuName =";
			String query2 = query2SELECTSTAR + "\'" + MenuName + "\'";
			LAMenu tempMenu = new LAMenu();
			tempMenu = Get.GetMenuData(conn, query2);
			
			if(tempMenu.getAmountOrder() != 0) {
				System.out.println("Menu is already ordered!");
				return;
			} else {
				System.out.println("Do you want to update or delete menu?");
				String opt = sc.nextLine();
				
				if(opt.equals("update")) {
					UpdateDeleteMenu.UpdateMenu(conn, MenuName);
				}else if(opt.equals("delete")) {
					Delete.DeleteMenu(conn, MenuName);
				} else {
					System.out.println("option not valid");
					return;
				}
			}
		}else {
			System.out.println("Menu doesn't exist");
			return;
		}
		
		return;
	}
	
	public static void UpdateMenu(Connection conn, String MenuName)
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("do you want to update menu name or price?");
		String op = sc.nextLine();
		
		if(op.equals("name")) {
			
			System.out.println("enter new menu name: ");
			String name = sc.nextLine();
			
			Update.UpdateMenuString(conn, name, MenuName);
			
		}else if(op.equals("price")) {
			
			System.out.println("enter new menu price: ");
			int price = sc.nextInt();sc.nextLine();
			
			Update.UpdateMenuInteger(conn, price, MenuName);
		}
	}
}
