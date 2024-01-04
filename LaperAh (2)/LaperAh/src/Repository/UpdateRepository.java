package Repository;

import java.sql.Connection;

import Operations.Update;

public class UpdateRepository 
{
	public static void UPDATE_CUSTOMERSTATUS_FINALIZED(Connection conn, String TransacID)
	{
		int intTransacID = Integer.parseInt(TransacID);
		String toSet = "Finalized";
		Update.UpdateTransactionStatus(conn, toSet, intTransacID);
	}
	
	public static void UPDATE_CUSTOMERSTATUS_INRESERVE(Connection conn, String TransacID)
	{
		int intTransacID = Integer.parseInt(TransacID);
		String toSet = "In Reserve";
		Update.UpdateTransactionStatus(conn, toSet, intTransacID);
	}
	
	public static void UPDATE_CUSTOMERSTATUS_INORDER(Connection conn, String TransacID)
	{
		int intTransacID = Integer.parseInt(TransacID);
		String toSet = "In Order";
		Update.UpdateTransactionStatus(conn, toSet, intTransacID);
	}
}
