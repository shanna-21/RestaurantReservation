package Main;

import java.sql.Connection;

import java.util.Scanner;

import Operations.Get;
import Operations.Insert;
import Operations.Update;
import Operations.Validate;
import Repository.UpdateRepository;
import Repository.ValidateRepository;
import SysConnection.SysConnection;
import Tables.LAMenu;
import Tables.LAStaff;
import Tables.LATransaction;

public class InsertOrders 
{
	static void DisplayMenu() 
	{
		Connection conn;
		conn = SysConnection.makeDBConnection();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Input TransactionID");
		String TransacID = sc.nextLine();
		
		if(!ValidateRepository.VALIDATE_TRANSACID(conn, TransacID))
		{
			
		}
		else
		{
			int option2 = 0;
			while(option2!=2)
			{
				System.out.println("1. Add New Order Item");
				System.out.println("2. Exit");
				option2 = sc.nextInt();sc.nextLine();
				
				switch(option2)
				{
				case 1:
					System.out.println("Add Order Name :");
					String MenuName = sc.nextLine();
					
					String queryValidateMenuName = "SELECT * FROM lamenu";
					Boolean isMenuNameValid = Validate.ValidateMenuName(conn, queryValidateMenuName, MenuName);
					
					if(isMenuNameValid == true)
					{
						System.out.println("Menu Is Found");
						String query2SELECTSTAR = "SELECT * FROM lamenu WHERE MenuName =";
						String query2 = query2SELECTSTAR + "\'" + MenuName + "\'";
						
						LAMenu tempMenu = new LAMenu();
						tempMenu = Get.GetMenuData(conn, query2);
						
						if(tempMenu.getMenuType().equals("Special") == true)
						{
							LATransaction tempTransaction = new LATransaction();
							LAStaff tempStaff = new LAStaff();
							
							String queryGetTransactionSELECTSTAR = "SELECT * FROM latransaction WHERE transactionID=";
							String queryGetTransaction = queryGetTransactionSELECTSTAR + TransacID;
							tempTransaction = Get.GetTransactionData(conn, queryGetTransaction);
							
							String queryJoinOnEmployeeTEMPLATE = "SELECT * FROM lastaff WHERE EmployeeID=";
							String queryJoinOnEmployee = queryJoinOnEmployeeTEMPLATE+ tempTransaction.getEmployeeID();
							tempStaff = Get.GetStaffData(conn, queryJoinOnEmployee);
							
							if(tempStaff.getBranchID().equals("JAK") || tempStaff.getBranchID().equals("BAN") || tempStaff.getBranchID().equals("BAL"))
							{
								// do nothing
							}
							else
							{
								System.out.println("Cannot Order Menu : ");
								System.out.println("Menu only available in Jakarta, Bandung and Bali");
								return;
							}
						}
						else if(tempMenu.getMenuType().contains("Local") == true)
						{
							LATransaction tempTransaction = new LATransaction();
							LAStaff tempStaff = new LAStaff();
							
							String queryGetTransactionSELECTSTAR = "SELECT * FROM latransaction WHERE transactionID=";
							String queryGetTransaction = queryGetTransactionSELECTSTAR + TransacID;
							tempTransaction = Get.GetTransactionData(conn, queryGetTransaction);
							
							String queryJoinOnEmployeeTEMPLATE = "SELECT * FROM lastaff WHERE EmployeeID=";
							String queryJoinOnEmployee = queryJoinOnEmployeeTEMPLATE+ tempTransaction.getEmployeeID();
							tempStaff = Get.GetStaffData(conn, queryJoinOnEmployee);
							
							if(tempStaff.getBranchID().equals("SUR") || tempStaff.getBranchID().equals("SAM") || tempStaff.getBranchID().equals("PAD"))
							{
								// do nothing
							}
							else
							{
								System.out.println("Cannot Order Menu : ");
								System.out.println("Menu only available in Surabaya, Samarinda and Padang");
								return;
							}
						}
						else
						{
							// do nothing
						}
						
						System.out.println("Add Amount : ");
						int MenuAmount = 0;
						while(MenuAmount == 0)
						{
							MenuAmount = sc.nextInt();sc.nextLine();
						}
						int NewNum = tempMenu.getAmountOrder() + MenuAmount;
						int intTransacID = Integer.parseInt(TransacID);
						
						Insert.InsertTransactionDetails(conn, tempMenu.getMenuID(), MenuAmount, intTransacID);
						UpdateRepository.UPDATE_CUSTOMERSTATUS_INORDER(conn, TransacID);
						Update.UpdateOrderedAmount(conn, NewNum, MenuName);
					}
					else
					{
						System.out.println("Menu is Not Found");
						break;
					}
					
					break;
				case 2:
					break;
				}
				
			}
			return;
		}
		
		
		
	}
}
