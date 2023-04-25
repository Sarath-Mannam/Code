import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection = null;
		try
		{
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 System.out.println("Driver loaded Successfully");
			 
			 String url = "jdbc:mysql://localhost:3306/octbatch";
			 String userName = "sarath";
			 String password = "root123";
			 connection = DriverManager.getConnection(url, userName, password);
			 System.out.println("connection established successfully...");
			 System.out.println("The implement class name is "+connection.getClass().getName());
	    }
		catch(ClassNotFoundException ce)
		{
			ce.printStackTrace();
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
