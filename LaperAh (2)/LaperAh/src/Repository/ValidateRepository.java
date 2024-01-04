package Repository;

import java.sql.Connection;
import java.util.Scanner;

import Operations.Validate;

public class ValidateRepository
{
	public static Boolean VALIDATE_TRANSACID(Connection conn, String TransacID)
	{
		String queryValidateTransactionID = "SELECT * FROM latransaction";
		Boolean isTransacIDValid = Validate.ValidateTransactionID(conn, queryValidateTransactionID, TransacID);
		
		if(isTransacIDValid == true)
		{
			System.out.println("TransactionID Is Found");
			return true;
		}
		else
		{
			System.out.println("TransactionID Not Found");
			return false;
		}
	}
	
	public static Boolean VALIDATE_PperT(String TType, int PperT)
	{
		if (TType.compareTo("Romantic") == 0)
		{
			if(PperT > 2)
			{
				System.out.println("Amount not Compatible(maximum 2)");
				System.out.println();
				
				return false;
			}
			else
			{
				return true;
			}
		}
		else if (TType.compareTo("General") == 0)
		{
			if(PperT > 4)
			{
				System.out.println("Amount not Compatible(maximum 4)");
				System.out.println();
				
				return false;
			}
			else
			{
				return true;
			}
		}
		else if (TType.compareTo("Family") == 0)
		{
			if(PperT > 10)
			{
				System.out.println("Amount not Compatible(maximum 10)");
				System.out.println();
				
				return false;
			}
			else
			{
				return true;
			}
		}
		else
		{
			return false;
		}
	}
	
	public static String VALIDATE_MENUTYPE(String newMenuType)
	{
		Scanner sc = new Scanner(System.in);
		String newMenuBackstory;
		
		if(newMenuType.compareTo("Special")==0)
		{
			System.out.println("Input Backstory");
			newMenuBackstory = sc.nextLine();
			
			return newMenuBackstory;
		}
		else if(newMenuType.contains("Local")==true)
		{
			System.out.println("Input Backstory");
			newMenuBackstory = sc.nextLine();
			
			return newMenuBackstory;
		}
		else
		{
			newMenuBackstory = null;
			return newMenuBackstory;
		}
	}
	
}
