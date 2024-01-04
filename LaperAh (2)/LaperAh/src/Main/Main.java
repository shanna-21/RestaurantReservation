package Main;
import java.util.Scanner;
import Repository.DisplayRepository;

public class Main 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		int option = 0;
		while(option!=7)
		{
			DisplayRepository.DISPLAY_MAINMENU();
			option = sc.nextInt();sc.nextLine();
			
			switch(option)
			{
			case 1:
				InsertReservation.DisplayMenu();
				break;
			case 2:
				InsertOrders.DisplayMenu();
				break;
			case 3:
				UpdateCustomerStatus.DisplayMenu();
				break;
			case 4:
				CustomerCheckout.DisplayMenu();
				break;
			case 5:
				InsertNewMenu.DisplayMenu();
				break;
			case 6:
				UpdateDeleteMenu.DisplayMenu();
				break;
			case 7:
				break;
			}
		}
		sc.close();
	}
	
	
}