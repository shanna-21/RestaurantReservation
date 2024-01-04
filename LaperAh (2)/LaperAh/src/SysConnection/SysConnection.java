package SysConnection;
import java.sql.*;

public class SysConnection 
{
	public static Connection makeDBConnection()
	{
		Connection conn;
		
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "laperah";
		String username = "root";
		String password = "";
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url+dbName,username,password);
			
			return conn;
		}
		catch(Exception e)
		{
			System.out.println(e);
			
			return null;
		}
	}
}
