package Main;

import java.sql.Connection;
import java.util.Scanner;
import Repository.DisplayRepository;
import Repository.UpdateRepository;
import Repository.ValidateRepository;
import SysConnection.SysConnection;

public class CustomerCheckout 
{
	public static void DisplayMenu() {
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
			UpdateRepository.UPDATE_CUSTOMERSTATUS_FINALIZED(conn, TransacID);
			DisplayRepository.DISPLAY_CHECKOUTBILL(conn, TransacID);
		}
		
		return;
	}
}	
