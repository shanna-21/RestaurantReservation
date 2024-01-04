package Main;

import java.sql.Connection;
import java.util.Scanner;

import Operations.Update;
import Operations.Validate;
import Repository.DisplayRepository;
import Repository.UpdateRepository;
import Repository.ValidateRepository;
import SysConnection.SysConnection;

public class UpdateCustomerStatus 
{
	static void DisplayMenu() {
		Connection conn;
		conn = SysConnection.makeDBConnection();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Insert Transaction ID");
		String TransacID = sc.nextLine();
		
		if(!ValidateRepository.VALIDATE_TRANSACID(conn, TransacID))
		{
			return;
		}
		else
		{
			DisplayRepository.DISPLAY_UPDATECUSTOMERMENU();
			
			int option3 = sc.nextInt();sc.nextLine();
			
			switch(option3)
			{
			case 1:
				UpdateRepository.UPDATE_CUSTOMERSTATUS_INRESERVE(conn, TransacID);
				break;
			case 2:
				UpdateRepository.UPDATE_CUSTOMERSTATUS_INORDER(conn, TransacID);
				break;
			case 3:
				UpdateRepository.UPDATE_CUSTOMERSTATUS_FINALIZED(conn, TransacID);
				break;
			}
		}
	}
}
